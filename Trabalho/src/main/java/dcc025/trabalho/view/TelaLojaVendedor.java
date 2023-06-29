package dcc025.trabalho.view;

import dcc025.trabalho.Usuario.Vendedor;
import dcc025.trabalho.model.Produto;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TelaLojaVendedor extends Tela{
    private final Vendedor usuario;
    
    private TelaComprador telaAnterior;
    
    private JList<Produto> jlistProdutos;
    
    public TelaLojaVendedor(TelaComprador telaAnterior, Vendedor vend) {
        usuario = vend;
        this.telaAnterior = telaAnterior;
        super.botoes = new ArrayList();
        super.labels = new ArrayList();
    }
    
    public void desenha(){
        tela = new JFrame();
        tela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tela.setSize(LARGURA, ALTURA/2);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
        tela.setLayout(new BorderLayout());
        
        desenhaMenu();
        carregaProdutos(Vendedor.getProdutosByVendedorID(usuario.getId()));
        
        tela.pack();
    }
    
    private void desenhaMenu(){
        JPanel painel = configuraPainelMain("Loja");
        
        labels.add(new JLabel("Nome: " + usuario.getNome()));
        
        JPanel painelAux = new JPanel();
        painelAux.add(desenhaLabel(labels));
        painelAux.add(desenhaLista("Produtos"));
        painelAux.add(desenhaBotoes(botoes));
        painel.add(painelAux, BorderLayout.CENTER);
        
        JPanel bpainel = new JPanel();
        
        //Botao Adicionar no Carrinho
        botoes.add(new JButton("Adicionar Produto ao carrinho"));
        botoes.get(0).addActionListener((java.awt.event.ActionEvent e) -> {
            //implementar a adição do produto no carrinho
        });
        
        //Botão Sair
        botoes.add(new JButton("Sair"));
        botoes.get(1).addActionListener((java.awt.event.ActionEvent e) -> {
            this.tela.dispose();
        });
        
        for(JButton botao : botoes)
            bpainel.add(botao);
        
        painel.add(bpainel, BorderLayout.SOUTH);
        
        tela.getContentPane().add(painel, BorderLayout.CENTER);
    }
    
    @Override
    protected JPanel desenhaLista(String string){

        JPanel painel = new JPanel();
        painel.setBorder(BorderFactory.createTitledBorder(string));
        painel.setPreferredSize(new Dimension(LARGURA, ALTURA/2));
        painel.setLayout(new BorderLayout());

        DefaultListModel<Produto> model = new DefaultListModel<>();

        jlistProdutos = new JList<>(model);

        painel.add(new JScrollPane(jlistProdutos), BorderLayout.CENTER);

        return painel;
    }
    
    public void carregaProdutos(java.util.List<Produto> produtos){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        model.clear();
        for (Produto c: produtos) {
            model.addElement(c);
        }
    }
    
    public java.util.List<Produto> listaProdutos(){
        DefaultListModel<Produto> model = (DefaultListModel<Produto>)jlistProdutos.getModel();
        java.util.List<Produto> produtos = new ArrayList<>();

        for (int i = 0; i < model.size(); i++) {
            produtos.add(model.get(i));
        }

        return produtos;
    }
}
