import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class GerenciamentoDeSobras extends JFrame {

    public JPanel GER;
    private JLabel EspessuraLabel;
    private JTextField EspessuraInput;
    private JLabel Largura;
    private JTextField LarguraInput;
    private JLabel ProfundidadeLabel;
    private JTextField ProfundidadeInput;
    private JButton CadastrarRetalhosButton;
    private JLabel AcabamentoLabel;
    private JTextField AcabamentoInput;
    private JTabbedPane Cadastros;
    private JButton PorAcabamentoButton;
    private JButton porEspessurasButton;
    private JTable tableListagem;
    private JTextField AreaCadastro;
    private JTable tableAreas;
    private JButton cadastrarAreaButton;
    private JButton porAreaButton;
    private JPanel AreasPanel;
    private JPanel ListagemPanel;
    private JPanel CadastroPanel;
    private JTextField ChapaArea;
    private JLabel areaCadastroArea;
    private JTable tableAcabamentos;
    private JTextField CadastroAcabamentoCodigo;
    private JButton cadastrarAcabamentoButton;
    private JButton excluirAcabamentoButton;
    private JTextField textField2;
    private JPasswordField passwordInput;
    private JButton fazerLoginButton;
    private JTextField pesquisaRetalhos;
    private JTextField CadastroAcabamentoNome;
    private JLabel Name;
    private JLabel Cod;
    private JCheckBox TemVeioCheck;
    private JButton ExcluirArea;
    private JTextField ExcluirAreasTXT;
    private JTextField resumoCadastro;
    private JScrollPane ScrollPanel;
    private JButton listarRetalhosButton;
    private JTextField excluirRetalhos;
    private JButton excluirChapas;
    private JButton ListarAcabamentos;
    private JScrollPane acabamentosTable;
    private JButton listarÁreasButton;
    private JTextPane logPanel;
    private JButton CONSULTARLOGButton;

    public GerenciamentoDeSobras() {
        cadastrarAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mdf = new MdfDAO();
                mdf.cadastrarAreas(AreaCadastro.getText());
            }
        });
        CadastrarRetalhosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Mdf retalho = new Mdf();
                MdfDAO cadastro = new MdfDAO();
                int esp = Integer.parseInt(EspessuraInput.getText());
                if(esp != 6 && esp != 15 && esp != 18 && esp != 25){
                    resumoCadastro.setText("Espessura Inválida" + esp);
                }else{
                    int acabVal = Integer.parseInt(AcabamentoInput.getText());
                    if(!cadastro.validaAcabamento(acabVal)) {
                        resumoCadastro.setText("Acabamento não existe");
                    }else{
                        String valArea = ChapaArea.getText();
                        if(!cadastro.validaArea(valArea)){
                            resumoCadastro.setText("Área não existe");
                        }else{
                            retalho.MdfSemId(Integer.parseInt(LarguraInput.getText()),
                                    Integer.parseInt(ProfundidadeInput.getText()),
                                    Integer.parseInt(EspessuraInput.getText()),
                                    AcabamentoInput.getText(),
                                    ChapaArea.getText().toUpperCase());
                            cadastro.cadastrarChapa(retalho);
                            resumoCadastro.setText("ID CADASTRADO: "+ retalho.ID() + " Na" +
                                    " Área: " + ChapaArea.getText().toUpperCase());
                        }
                    }

                }

            }
        });
        cadastrarAcabamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO cadastro = new MdfDAO();
                int veio = 0;
                if (TemVeioCheck.isSelected()){
                    veio =1;
                }
                cadastro.cadastrarAcabamento(CadastroAcabamentoNome.getText()
                        ,veio
                        ,Integer.parseInt(CadastroAcabamentoCodigo.getText()));
            }
        });
        excluirAcabamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO excluir = new MdfDAO();
                excluir.excluirAcabamentos(Integer.parseInt(CadastroAcabamentoCodigo.getText()));
            }
        });
        ExcluirArea.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO excluirArea = new MdfDAO();
                excluirArea.excluirAreas(ExcluirAreasTXT.getText());
            }
        });






        EspessuraInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                EspessuraInput.setText("");
            }
        });
        LarguraInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                LarguraInput.setText("");
            }
        });
        ProfundidadeInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ProfundidadeInput.setText("");
            }
        });
        AcabamentoInput.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                AcabamentoInput.setText("");
            }
        });
        AreaCadastro.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                AreaCadastro.setText("");
            }
        });
        ChapaArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                super.focusGained(e);
                ChapaArea.setText("");
            }
        });
        PorAcabamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(PorAcabamentoButton,"Teste");
            }
        });
        tableListagem.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);

            }
        });
        PorAcabamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarAcabamento = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("Acabamento");
                table.addColumn("Espessura");
                table.addColumn("Largura");
                table.addColumn("Profundidade");
                table.addColumn("Area");

                for (Mdf mdf :
                        mostrarAcabamento.listarRetalhosPorAcabamento(Integer.parseInt(pesquisaRetalhos.getText()))) {
                    table.addRow(new Object[]{mdf.getAcabamento(),
                            mdf.getEsp(),mdf.getLarg(),mdf.getProf(),mdf.getArea()});
                }
                tableListagem.setModel(table);

            }
        });
        listarRetalhosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarTabela = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("Acabamento");
                table.addColumn("Espessura");
                table.addColumn("Largura");
                table.addColumn("Profundidade");
                table.addColumn("Area");

                for (Mdf mdf : mostrarTabela.listarRetalhos()) {
                    table.addRow(new Object[]{mdf.getAcabamento(),
                            mdf.getEsp(),mdf.getLarg(),mdf.getProf(),
                            mdf.getArea()});
                }
                tableListagem.setModel(table);


            }
        });
        excluirChapas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            MdfDAO excluir = new MdfDAO();
            excluir.excluirChapa(excluirRetalhos.getText());
            }
        });
        porEspessurasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarEspessura = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("Acabamento");
                table.addColumn("Espessura");
                table.addColumn("Largura");
                table.addColumn("Profundidade");
                table.addColumn("Area");

                for (Mdf mdf :
                        mostrarEspessura.listarRetalhosPorEspessura(Integer.parseInt(pesquisaRetalhos.getText()))) {
                    table.addRow(new Object[]{mdf.getAcabamento(),
                            mdf.getEsp(),mdf.getLarg(),mdf.getProf(),mdf.getArea()});
                }
                tableListagem.setModel(table);
            }
        });
        porAreaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarArea = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("Acabamento");
                table.addColumn("Espessura");
                table.addColumn("Largura");
                table.addColumn("Profundidade");
                table.addColumn("Area");

                for (Mdf mdf :
                        mostrarArea.listarRetalhosPorArea(pesquisaRetalhos.getText())) {
                    table.addRow(new Object[]{mdf.getAcabamento(),
                            mdf.getEsp(),mdf.getLarg(),mdf.getProf(),mdf.getArea()});
                }
                tableListagem.setModel(table);
            }
        });
        ListarAcabamentos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarAcabamentos = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("Acabamento");
                table.addColumn("Veio");
                table.addColumn("Código");

                for (Mdf mdf : mostrarAcabamentos.listarAcabamentos()){
                    table.addRow(new Object[]{mdf.getAcabamento(),
                            mdf.getVeio(),mdf.getCod()});
                }

                tableAcabamentos.setModel(table);
            }
        });
        listarÁreasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MdfDAO mostrarAcabamentos = new MdfDAO();
                DefaultTableModel table = new DefaultTableModel();
                table.addColumn("name");

                for (Mdf mdf : mostrarAcabamentos.listarAreas()){
                    table.addRow(new Object[]{mdf.getArea()});
                }

                tableAreas.setModel(table);
            }
        });
        CONSULTARLOGButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    BufferedReader reader =
                            new BufferedReader(new FileReader("Log.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        logPanel.getDocument().insertString(logPanel.getDocument().getLength(), line + "\n", null);
                    }
                    reader.close();

                } catch (IOException a) {
                    a.printStackTrace();
                } catch (Exception a) {
                    a.printStackTrace();
                }

            }
        });
    }


//    private void createUIComponents() {
//        // TODO: place custom component creation code here
//
//    }



}
