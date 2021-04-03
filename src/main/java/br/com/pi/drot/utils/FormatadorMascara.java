package br.com.pi.drot.utils;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class FormatadorMascara {

    private TextField campoTexto;
    private DatePicker selecionadorDado;
    private int mascaraSelecionada;
    private boolean usarSelecionadorData;
    public static final int TEL_8DIG = 0;
    public static final int TEL_9DIG = 1;
    public static final int CPF = 2;
    public static final int RG = 3;
    public static final int DATA_BARRA = 4;
    public static final int DATA_TRACO = 5;
    public static final int CEP = 6;

    public FormatadorMascara(TextField campoTexto) {
        this.campoTexto = campoTexto;
    }

    public FormatadorMascara(DatePicker datePicker) {
        this.selecionadorDado = datePicker;
        this.usarSelecionadorData = true;
    }

    public void setMask(int tipoMascara) {
        this.mascaraSelecionada = tipoMascara;
        if (!usarSelecionadorData) {
            switch (tipoMascara) {
                case TEL_8DIG:
                	mascaraTelefone8Dig();
                    break;

                case TEL_9DIG:
                	mascaraTelefone9Dig();
                    break;

                case CPF:
                    mascaraCPF();
                    break;

                case RG:
                    mascaraRG();
                    break;

                case CEP:
                	mascaraCEP();
                	break;

                default:
                    break;
            }
        } else {
            switch (tipoMascara) {
                case DATA_BARRA:
                	mascaraBarraDeDados();
                    break;
                case DATA_TRACO:
                    maskDataTraco();
                    break;
                default:
                    break;
            }
        }
    }

    private void mascaraTelefone8Dig() {
        campoTexto.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }
            if (evento.getCharacter().trim().length() == 0) {
                switch (campoTexto.getText().length()) {
                    case 9:
                    	campoTexto.setText(campoTexto.getText().substring(0, 8));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 3:
                        campoTexto.setText(campoTexto.getText().substring(0, 2));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 1:
                        campoTexto.setText("");
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    default:
                        break;
                }
            } else if (campoTexto.getText().length() == 14) {
                evento.consume();
            }
            switch (campoTexto.getText().length()) {
                case 1:
                    campoTexto.setText("(" + campoTexto.getText());
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 3:
                    campoTexto.setText(campoTexto.getText() + ") ");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 9:
                    campoTexto.setText(campoTexto.getText() + "-");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
            }

        });
    }

    private void mascaraTelefone9Dig() {
        campoTexto.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (campoTexto.getText().length()) {
                    case 1:
                        campoTexto.setText("");
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 3:
                        campoTexto.setText(campoTexto.getText().substring(0, 2));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 10:
                        campoTexto.setText(campoTexto.getText().substring(0, 9));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                }
            } else if (campoTexto.getText().length() == 15) {
                evento.consume();
            }
            switch (campoTexto.getText().length()) {
                case 1:
                    campoTexto.setText("(" + campoTexto.getText());
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 3:
                    campoTexto.setText(campoTexto.getText() + ") ");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 10:
                    campoTexto.setText(campoTexto.getText() + "-");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
            }

        });
    }

    private void mascaraCPF() {
        campoTexto.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (campoTexto.getText().length()) {
                    case 11:
                        campoTexto.setText(campoTexto.getText().substring(0, 9));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 7:
                        campoTexto.setText(campoTexto.getText().substring(0, 6));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 3:
                        campoTexto.setText(campoTexto.getText().substring(0, 2));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                }

            } else if (campoTexto.getText().length() == 14) {
                evento.consume();
            }

            switch (campoTexto.getText().length()) {
                case 3:
                    campoTexto.setText(campoTexto.getText() + ".");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 7:
                    campoTexto.setText(campoTexto.getText() + ".");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 11:
                    campoTexto.setText(campoTexto.getText() + "-");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
            }

        });
    }

    public void mascaraCEP() {
    	campoTexto.setOnKeyTyped((KeyEvent evento) -> {
    		if (!"0123456789".contains(evento.getCharacter())) {
    			evento.consume();
    		}

    		if (evento.getCharacter().trim().length() == 0) {
    			switch (campoTexto.getText().length()) {
    				case 5:
    					campoTexto.setText(campoTexto.getText().substring(0, 4));
    					campoTexto.positionCaret(campoTexto.getText().length());
    					break;
    			}
    		} else if (campoTexto.getText().length() == 9) {
    			evento.consume();
    		}

    		switch (campoTexto.getText().length()) {
    			case 5:
    				campoTexto.setText(campoTexto.getText() + "-");
    				campoTexto.positionCaret(campoTexto.getText().length());
    				break;
    		}
    	});
    }


    private void mascaraRG() {
        campoTexto.setOnKeyTyped((KeyEvent evento) -> {
            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (campoTexto.getText().length()) {
                    case 2:
                        campoTexto.setText(campoTexto.getText().substring(0, 1));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 6:
                        campoTexto.setText(campoTexto.getText().substring(0, 5));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                    case 10:
                        campoTexto.setText(campoTexto.getText().substring(0, 9));
                        campoTexto.positionCaret(campoTexto.getText().length());
                        break;
                }

            } else if (campoTexto.getText().length() == 12) {
                evento.consume();
            }

            switch (campoTexto.getText().length()) {
                case 2:
                    campoTexto.setText(campoTexto.getText() + ".");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 6:
                    campoTexto.setText(campoTexto.getText() + ".");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
                case 10:
                    campoTexto.setText(campoTexto.getText() + "-");
                    campoTexto.positionCaret(campoTexto.getText().length());
                    break;
            }

        });

    }

    private void mascaraBarraDeDados() {
        selecionadorDado.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (selecionadorDado.getEditor().getText().length()) {
                    case 2:
                    	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText().substring(0, 1));
                    	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                        break;
                    case 5:
                    	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText().substring(0, 4));
                    	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                        break;
                }
            } else if (selecionadorDado.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (selecionadorDado.getEditor().getText().length()) {
                case 2:
                	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText() + "/");
                	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                    break;
                case 5:
                	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText() + "/");
                	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                    break;
            }

        });
    }

    private void maskDataTraco() {
    	selecionadorDado.getEditor().setOnKeyTyped((KeyEvent evento) -> {

            if (!"0123456789".contains(evento.getCharacter())) {
                evento.consume();
            }

            if (evento.getCharacter().trim().length() == 0) {
                switch (selecionadorDado.getEditor().getText().length()) {
                    case 2:
                    	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText().substring(0, 1));
                    	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                        break;
                    case 5:
                    	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText().substring(0, 4));
                    	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                        break;
                }
            } else if (selecionadorDado.getEditor().getText().length() == 10) {
                evento.consume();
            }
            switch (selecionadorDado.getEditor().getText().length()) {
                case 2:
                	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText()+"-");
                    selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                    break;
                case 5:
                	selecionadorDado.getEditor().setText(selecionadorDado.getEditor().getText()+"-");
                	selecionadorDado.getEditor().positionCaret(selecionadorDado.getEditor().getText().length());
                    break;
            }

        });
    }

    public void exibirMascara() {
        switch (this.mascaraSelecionada) {
            case TEL_8DIG:
                campoTexto.setPromptText("(__) ____-____");
                break;

            case TEL_9DIG:
            	campoTexto.setPromptText("(__) _____-____");
                break;

            case CPF:
                campoTexto.setPromptText("___.___.___-__");
                break;

            case RG:
                campoTexto.setPromptText("__.___.___-_");
                break;

            case DATA_BARRA:
            	selecionadorDado.setPromptText("__/__/____");
                break;

            case DATA_TRACO:
                selecionadorDado.setPromptText("__-__-____");
                break;

            case CEP:
            	selecionadorDado.setPromptText("_____-___");
            	break;

            default:
                break;
        }
    }

    public void addComponente(TextField campoTexto, int tipoMascara, boolean exibirMascara) {
        FormatadorMascara formatter = new FormatadorMascara(campoTexto);
        formatter.setMask(tipoMascara);
        if (exibirMascara) {
            formatter.exibirMascara();
        }
    }

    public void addComponente(DatePicker selecionadorData, int tipoMascara, boolean exibirMascara) {
        FormatadorMascara formatter = new FormatadorMascara(selecionadorData);
        formatter.setMask(tipoMascara);
        if (exibirMascara) {
            formatter.exibirMascara();
        }
    }

}
