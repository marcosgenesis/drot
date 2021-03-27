package br.com.pi.drot.utils;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MaskFormatter {

    private TextField textField;
    private DatePicker datePicker;
    private int maskSelecionada;
    private boolean usarDatePicker;
    public static final int TEL_8DIG = 0;
    public static final int TEL_9DIG = 1;
    public static final int CPF = 2;
    public static final int RG = 3;
    public static final int DATA_BARRA = 4;
    public static final int DATA_TRACO = 5;

    public MaskFormatter(TextField textField) {
        this.textField = textField;

    }

    public MaskFormatter(DatePicker datePicker) {
        this.datePicker = datePicker;
        this.usarDatePicker = true;
    }

    public void setMask(int maskType) {
        this.maskSelecionada = maskType;
        if (!usarDatePicker) {

            switch (maskType) {
                case TEL_8DIG:
                    maskTel8Dig();
                    break;
                case TEL_9DIG:
                    maskTel9Dig();
                    break;
                case CPF:
                    maskCpf();
                    break;
                case RG:
                    maskRg();
                    break;
                default:
                    break;
            }
        } else {
            switch (maskType) {
                case DATA_BARRA:
                    maskDataBarra();
                    break;
                case DATA_TRACO:
                    maskDataTraco();
                    break;
                default:
                    break;
            }
        }
    }

    private void maskTel8Dig() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }
            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 9:
                        textField.setText(textField.getText().substring(0, 8));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    default:
                        break;
                }
            } else if (textField.getText().length() == 14) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    textField.setText("(" + textField.getText());
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 9:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskTel9Dig() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 1:
                        textField.setText("");
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }
            } else if (textField.getText().length() == 15) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 1:
                    textField.setText("(" + textField.getText());
                    textField.positionCaret(textField.getText().length());
                    break;
                case 3:
                    textField.setText(textField.getText() + ") ");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskCpf() {

        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 11:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 7:
                        textField.setText(textField.getText().substring(0, 6));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 3:
                        textField.setText(textField.getText().substring(0, 2));
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 14) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 3:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 7:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 11:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });
    }

    private void maskRg() {
        textField.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {

                switch (textField.getText().length()) {
                    case 2:
                        textField.setText(textField.getText().substring(0, 1));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 6:
                        textField.setText(textField.getText().substring(0, 5));
                        textField.positionCaret(textField.getText().length());
                        break;
                    case 10:
                        textField.setText(textField.getText().substring(0, 9));
                        textField.positionCaret(textField.getText().length());
                        break;
                }

            } else if (textField.getText().length() == 12) {
                evento.consume();
            }
            switch (textField.getText().length()) {
                case 2:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 6:
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                    break;
                case 10:
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                    break;
            }

        });

    }

    private void maskDataBarra() {
        datePicker.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (datePicker.getEditor().getText().length()) {
                    case 2:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 1));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                    case 5:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 4));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                }
            } else if (datePicker.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (datePicker.getEditor().getText().length()) {
                case 2:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
                case 5:
                    datePicker.getEditor().setText(datePicker.getEditor().getText() + "/");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
            }

        });
    }

    private void maskDataTraco() {
        datePicker.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (datePicker.getEditor().getText().length()) {
                    case 2:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 1));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                    case 5:
                        datePicker.getEditor().setText(datePicker.getEditor().getText().substring(0, 4));
                        datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                        break;
                }
            } else if (datePicker.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (datePicker.getEditor().getText().length()) {
                case 2:
                    datePicker.getEditor().setText(datePicker.getEditor().getText()+"-");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
                case 5:
                    datePicker.getEditor().setText(datePicker.getEditor().getText()+"-");
                    datePicker.getEditor().positionCaret(datePicker.getEditor().getText().length());
                    break;
            }

        });
    }

    public void showMask() {
        switch (this.maskSelecionada) {
            case TEL_8DIG:
                textField.setPromptText("(__) ____-____");
                break;
            case TEL_9DIG:
                textField.setPromptText("(__) _____-____");
                break;
            case CPF:
                textField.setPromptText("___.___.___-__");
                break;
            case RG:
                textField.setPromptText("__.___.___-_");
                break;
            case DATA_BARRA:
                datePicker.setPromptText("__/__/____");
                break;
            case DATA_TRACO:
                datePicker.setPromptText("__-__-____");
                break;
            default:
                break;
        }
    }

    public void addComponente(TextField field, int maskType, boolean showMask) {
        MaskFormatter formatter = new MaskFormatter(textField);
        formatter.setMask(maskType);
        if (showMask) {
            formatter.showMask();
        }
    }

    public void addComponente(DatePicker datePicker, int maskType, boolean showMask) {
        MaskFormatter formatter = new MaskFormatter(datePicker);
        formatter.setMask(maskType);
        if (showMask) {
            formatter.showMask();
        }
    }

}
