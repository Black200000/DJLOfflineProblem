package org.example;

import ai.djl.MalformedModelException;
import ai.djl.inference.Predictor;
import ai.djl.ndarray.NDArray;
import ai.djl.ndarray.NDList;
import ai.djl.ndarray.NDManager;
import ai.djl.repository.zoo.Criteria;
import ai.djl.repository.zoo.ModelNotFoundException;
import ai.djl.repository.zoo.ZooModel;
import ai.djl.training.util.ProgressBar;
import ai.djl.translate.NoBatchifyTranslator;
import ai.djl.translate.TranslateException;
import ai.djl.translate.TranslatorContext;

import java.io.IOException;
import java.nio.file.Paths;

public class Final {
    public static void main(String[] args) throws IOException, TranslateException, MalformedModelException, ModelNotFoundException {
        Criteria<CModelDoubleInput, NDList> criteria = Criteria.builder()
                .setTypes(CModelDoubleInput.class, NDList.class)
                .optModelPath(Paths.get("model"))
                .optModelName("type_detection_jit.pt")
                .optOption("mapLocation", "true")
                .optTranslator(new NoBatchifyTranslator<CModelDoubleInput, NDList>() {
                    @Override
                    public NDList processInput(TranslatorContext translatorContext, CModelDoubleInput cModelDoubleInput) throws Exception {
                        NDList ndList = new NDList();
                        NDManager ndManager = translatorContext.getNDManager();
                        ndList.add(ndManager.create(cModelDoubleInput.fInput).reshape(1, 3, 62));
                        ndList.add(ndManager.create(cModelDoubleInput.iInput).reshape(1, 3, 32));
                        return ndList;
                    }

                    @Override
                    public NDList processOutput(TranslatorContext translatorContext, NDList ndList) throws Exception {
                        NDArray ndArray = ndList.get(0);
                        System.out.println("ndList: " + ndList.toString());
                        System.out.println("ndArray: " + ndArray.toString());
                        return ndList;
                    }
                })
                .optProgress(new ProgressBar()).build();

        ZooModel<CModelDoubleInput, NDList> model = criteria.loadModel();
        Predictor<CModelDoubleInput, NDList> predictor = model.newPredictor();

        CModelDoubleInput mdi = new CModelDoubleInput();

        mdi.fInput = new float[3][62];
        mdi.fInput[0][8] = 88.87f;
        mdi.iInput = new int[3][32];
        mdi.iInput[0][7] = 12;
        NDList pred = predictor.predict(mdi);
    }
}
