package com.example.slab1;

//package com.example.slab1;

import java.net.URL;
import java.util.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.converter.IntegerStringConverter;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField AcsBs;

    @FXML
    private TextField AcsNz;

    @FXML
    private TextField AcsSpad;

    @FXML
    private TextField AcsSs;

    @FXML
    private TextField AnsGurwez;

    @FXML
    private TextField AnsLaplasa;

    @FXML
    private TextField AnsMax;

    @FXML
    private TextField AnsSavidg;

    @FXML
    private TextField AnsWalda;

    @FXML
    private Button BtGurwez;

    @FXML
    private Button BtLaplasa;

    @FXML
    private Button BtMax;

    @FXML
    private Button BtSavidg;

    @FXML
    private Button BtWalda;

    @FXML
    private TextField DepBs;

    @FXML
    private TextField DepNz;

    @FXML
    private TextField DepSpad;

    @FXML
    private TextField DepSs;

    @FXML
    private TextField OblBs;

    @FXML
    private TextField OblNz;

    @FXML
    private TextField OblSpad;

    @FXML
    private TextField OblSs;

    @FXML
    private Text TextAnswerGz;

    @FXML
    private Text TextAnswerLaplasa;

    @FXML
    private Text TextAnswerMax;

    @FXML
    private Text TextAnswerSavidg;

    @FXML
    private Text TextAnswerWalda;

    @FXML
    void initialize() {
        setTextFieldIntegerOnly(DepBs);
        setTextFieldIntegerOnly(DepNz);
        setTextFieldIntegerOnly(DepSpad);
        setTextFieldIntegerOnly(DepSs);
        setTextFieldIntegerOnly(OblBs);
        setTextFieldIntegerOnly(OblNz);
        setTextFieldIntegerOnly(OblSpad);
        setTextFieldIntegerOnly(OblSs);
        setTextFieldIntegerOnly(AcsBs);
        setTextFieldIntegerOnly(AcsNz);
        setTextFieldIntegerOnly(AcsSpad);
        setTextFieldIntegerOnly(AcsSs);
    }

    private String critAcz = "Рекомендуется выбрать вторую стратегию, то есть покупку акций предприятия";
    private String critDep = "Рекомендуется выбрать третью стратегию, то есть покупку депозита предприятия";
    private String critObl = "Рекомендуется выбрать первую стратегию, то есть покупку облигаций предприятия";
    private void setTextFieldIntegerOnly(TextField textField) {
        TextFormatter<Integer> textFormatter = new TextFormatter<>(
                new IntegerStringConverter(),
                null,
                change -> {
                    if (change.isContentChange()) {
                        if (!change.getControlNewText().matches("-?\\d*")) {
                            showAlert("Введите целое число!");
                            return null;
                        }
                        return change;
                    }
                    return change;
                }
        );
        textField.setTextFormatter(textFormatter);
    }

    // Метод для отображения сообщения
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Предупреждение");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void calculateLaplasa(ActionEvent event) {
        int depBs = Integer.parseInt(DepBs.getText());
        int depNz = Integer.parseInt(DepNz.getText());
        int depSpad = Integer.parseInt(DepSpad.getText());
        int depSs = Integer.parseInt(DepSs.getText());

        int oblBs = Integer.parseInt(OblBs.getText());
        int oblNz = Integer.parseInt(OblNz.getText());
        int oblSpad = Integer.parseInt(OblSpad.getText());
        int oblSs = Integer.parseInt(OblSs.getText());
        int acsBs = Integer.parseInt(AcsBs.getText());
        int acsNz = Integer.parseInt(AcsNz.getText());
        int acsSpad = Integer.parseInt(AcsSpad.getText());
        int acsSs = Integer.parseInt(AcsSs.getText());

        int[] massivObl = {oblBs, oblNz, oblSs, oblSpad};
        int[] massivAcz = {acsBs, acsNz, acsSs, acsSpad};
        int[] massivDep = {depBs, depNz, depSs, depSpad};

        int[] max = {Arrays.stream(massivObl).sum(), Arrays.stream(massivAcz).sum(), Arrays.stream(massivDep).sum()};
        int valueLaplasa = Arrays.stream(max).max().getAsInt();

        if (valueLaplasa == Arrays.stream(massivDep).sum())  TextAnswerLaplasa.setText(critObl);
        else if (valueLaplasa == Arrays.stream(massivObl).sum())  TextAnswerLaplasa.setText(critObl);
        else if (valueLaplasa == Arrays.stream(massivAcz).sum())  TextAnswerLaplasa.setText(critAcz);

        AnsLaplasa.setText(String.valueOf(valueLaplasa));
    }

    @FXML
    void calculateSavidg(ActionEvent event) {
        int depBs = Integer.parseInt(DepBs.getText());
        int depNz = Integer.parseInt(DepNz.getText());
        int depSpad = Integer.parseInt(DepSpad.getText());
        int depSs = Integer.parseInt(DepSs.getText());

        int oblBs = Integer.parseInt(OblBs.getText());
        int oblNz = Integer.parseInt(OblNz.getText());
        int oblSpad = Integer.parseInt(OblSpad.getText());
        int oblSs = Integer.parseInt(OblSs.getText());
        int acsBs = Integer.parseInt(AcsBs.getText());
        int acsNz = Integer.parseInt(AcsNz.getText());
        int acsSpad = Integer.parseInt(AcsSpad.getText());
        int acsSs = Integer.parseInt(AcsSs.getText());

        ArrayList<Integer> listFast = new ArrayList<>();
        ArrayList<Integer> listSred = new ArrayList<>();
        ArrayList<Integer> listNeizmen = new ArrayList<>();
        ArrayList<Integer> listSpad = new ArrayList<>();

        listFast.add(depBs);
        listFast.add(oblBs);
        listFast.add(acsBs);

        listSred.add(depSs);
        listSred.add(oblSs);
        listSred.add(acsSs);

        listNeizmen.add(depNz);
        listNeizmen.add(oblNz);
        listNeizmen.add(acsNz);

        listSpad.add(depSpad);
        listSpad.add(oblSpad);
        listSpad.add(acsSpad);

        int listMaxFast = Collections.max(listFast);
        int listMaxSred = Collections.max(listSred);
        int listMaxNeizmen = Collections.max(listNeizmen);
        int listMaxSpad = Collections.max(listSpad);

        int newDepBs = listMaxFast - depBs;
        int newDepNz = listMaxNeizmen - depNz;
        int newDepSpad = listMaxSred - depSpad;
        int newDepSs = listMaxSred - depSs;

        int newOblBs = listMaxFast - oblBs;
        int newOblNz = listMaxNeizmen - oblNz;
        int newOblSpad = listMaxSpad - oblSpad;
        int newOblSs = listMaxSred - oblSs;

        int newAcsBs = listMaxFast - acsBs;
        int newAcsNz = listMaxNeizmen - acsNz;
        int newAcsSpad = listMaxSpad - acsSpad;
        int newAcsSs = listMaxSred - acsSs;

        int[] maxObdl = new int[4];
        int[] maxAcz = new int[4];
        int[] maxDep = new int[4];

        maxObdl[0] = newOblBs;
        maxObdl[1] = newOblSs;
        maxObdl[2] = newOblNz;
        maxObdl[3] = newOblSpad;

        maxAcz[0] = newAcsBs;
        maxAcz[1] = newAcsSs;
        maxAcz[2] = newAcsNz;
        maxAcz[3] = newAcsSpad;

        maxDep[0] = newDepBs;
        maxDep[1] = newDepSs;
        maxDep[2] = newDepNz;
        maxDep[3] = newDepSpad;

        int maxNewObl = Arrays.stream(maxObdl).max().getAsInt();
        int maxNewAcs = Arrays.stream(maxAcz).max().getAsInt();
        int maxNewDep = Arrays.stream(maxDep).max().getAsInt();

        int[] savidsgMassiv = {maxNewAcs, maxNewObl, maxNewDep};
        int savidgValue = Arrays.stream(savidsgMassiv).min().getAsInt();

        if (savidgValue == maxNewObl)  TextAnswerSavidg.setText(critObl);
        else if (savidgValue == maxNewAcs)  TextAnswerSavidg.setText(critAcz);
        else if (savidgValue == maxNewDep)  TextAnswerSavidg.setText(critDep);

        AnsSavidg.setText(String.valueOf(savidgValue));

    }

    @FXML
    void calculateGz(ActionEvent event) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Оптимизм");
        dialog.setHeaderText("Введите значение оптимизма:");
        dialog.setContentText("Оптимизм:");

        // Отображение диалогового окна и ожидание ввода значения
        Optional<String> result = dialog.showAndWait();

        // Обработка введенного значения
        result.ifPresent(value -> {
            try {
                double optimizm = Double.parseDouble(value);

                int minDep1 = Integer.parseInt(DepBs.getText());
                int minDep2 = Integer.parseInt(DepSs.getText());
                int minDep3 = Integer.parseInt(DepNz.getText());
                int minDep4 = Integer.parseInt(DepSpad.getText());

                int minObl1 = Integer.parseInt(OblBs.getText());
                int minObl2 = Integer.parseInt(OblSs.getText());
                int minObl3 = Integer.parseInt(OblNz.getText());
                int minObl4 = Integer.parseInt(OblSpad.getText());

                int minAcz1 = Integer.parseInt(AcsBs.getText());
                int minAcz2 = Integer.parseInt(AcsSs.getText());
                int minAcz3 = Integer.parseInt(AcsNz.getText());
                int minAcz4 = Integer.parseInt(AcsSpad.getText());

                int maxDep = Math.max(Math.max(minDep1, minDep2), Math.max(minDep3, minDep4));
                int maxObl = Math.max(Math.max(minObl1, minObl2), Math.max(minObl3, minObl4));
                int maxAcz = Math.max(Math.max(minAcz1, minAcz2), Math.max(minAcz3, minAcz4));

                int minDep = Math.min(Math.min(minDep1, minDep2), Math.min(minDep3, minDep4));
                int minObl = Math.min(Math.min(minObl1, minObl2), Math.min(minObl3, minObl4));
                int minAcz = Math.min(Math.min(minAcz1, minAcz2), Math.min(minAcz3, minAcz4));

                double mDp = optimizm * minDep + (1 - optimizm) * maxDep;
                double mOb = optimizm * minObl + (1 - optimizm) * maxObl;
                double mAz = optimizm * minAcz + (1 - optimizm) * maxAcz;

                double max = Math.max(Math.max(mDp, mOb), mAz);

                AnsGurwez.setText(String.valueOf(max));

                if (mDp == max) {
                    TextAnswerGz.setText(critDep);
                } else if (maxAcz == max) {
                    TextAnswerGz.setText(critAcz);
                } else {
                    TextAnswerGz.setText(critObl);
                }

            } catch (NumberFormatException e) {
                showAlert("Введите целое не отрицательное число!");
                // Обработка ошибки в случае некорректного формата числа
                System.out.println("Ошибка: Введите корректное числовое значение для оптимизма");
            }
        });
    }

    @FXML
    void calculateValda(ActionEvent event) {
        int minDep1 = Integer.parseInt(DepBs.getText());
        int minDep2 = Integer.parseInt(DepSs.getText());
        int minDep3 = Integer.parseInt(DepNz.getText());
        int minDep4 = Integer.parseInt(DepSpad.getText());

        int minObl1 = Integer.parseInt(OblBs.getText());
        int minObl2 = Integer.parseInt(OblSs.getText());
        int minObl3 = Integer.parseInt(OblNz.getText());
        int minObl4 = Integer.parseInt(OblSpad.getText());

        int minAcz1 = Integer.parseInt(AcsBs.getText());
        int minAcz2 = Integer.parseInt(AcsSs.getText());
        int minAcz3 = Integer.parseInt(AcsNz.getText());
        int minAcz4 = Integer.parseInt(AcsSpad.getText());

        int minDep = Math.min(Math.min(minDep1, minDep2), Math.min(minDep3, minDep4));
        int minObl = Math.min(Math.min(minObl1, minObl2), Math.min(minObl3, minObl4));
        int minAcz = Math.min(Math.min(minAcz1, minAcz2), Math.min(minAcz3, minAcz4));

        int max = Math.max(Math.max(minDep, minObl), minAcz);

        AnsWalda.setText(String.valueOf(max));

        if (minDep == max) {
            TextAnswerWalda.setText(critDep);
        } else if (minAcz == max) {
            TextAnswerWalda.setText(critAcz);
        } else {
            TextAnswerWalda.setText(critObl);
        }
    }

    @FXML
    void calculateMax(ActionEvent event) {
        int minDep1 = Integer.parseInt(DepBs.getText());
        int minDep2 = Integer.parseInt(DepSs.getText());
        int minDep3 = Integer.parseInt(DepNz.getText());
        int minDep4 = Integer.parseInt(DepSpad.getText());

        int minObl1 = Integer.parseInt(OblBs.getText());
        int minObl2 = Integer.parseInt(OblSs.getText());
        int minObl3 = Integer.parseInt(OblNz.getText());
        int minObl4 = Integer.parseInt(OblSpad.getText());

        int minAcz1 = Integer.parseInt(AcsBs.getText());
        int minAcz2 = Integer.parseInt(AcsSs.getText());
        int minAcz3 = Integer.parseInt(AcsNz.getText());
        int minAcz4 = Integer.parseInt(AcsSpad.getText());

        int minDep = Math.max(Math.max(minDep1, minDep2), Math.max(minDep3, minDep4));
        int minObl = Math.max(Math.max(minObl1, minObl2), Math.max(minObl3, minObl4));
        int minAcz = Math.max(Math.max(minAcz1, minAcz2), Math.max(minAcz3, minAcz4));

        int max = Math.max(Math.max(minDep, minObl), minAcz);

        AnsMax.setText(String.valueOf(max));

        if (minDep == max) {
            TextAnswerMax.setText(critDep);
        } else if (minAcz == max) {
            TextAnswerMax.setText(critAcz);
        } else {
            TextAnswerMax.setText(critObl);
        }
    }

}
