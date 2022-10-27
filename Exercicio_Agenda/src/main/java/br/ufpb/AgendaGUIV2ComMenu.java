package br.ufpb;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AgendaGUIV2ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon artAniversario = new ImageIcon("./src/main/java/br/ufpb/imgs/artAniversario.jpg");
    ImageIcon addImg = new ImageIcon("./src/main/java/br/ufpb/imgs/adicionarImg.png");
    ImageIcon pesqImg = new ImageIcon("./src/main/java/br/ufpb/imgs/pesquisarImg.png");
    ImageIcon removeImg = new ImageIcon("./src/main/java/br/ufpb/imgs/removerImg.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    AgendaInterface agenda = new AgendaIvan();
    JMenuBar barraDeMenu = new JMenuBar();

    public AgendaGUIV2ComMenu() {
        setTitle("Agenda de Aniversários");
        setSize(700, 500);
        setLocation(150, 150);
        setResizable(false);
        getContentPane().setBackground(Color.white);
        linha1 = new JLabel("Minha Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Arial", Font.BOLD, 22));
        linha2 = new JLabel(artAniversario, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar", addImg);
        botaoAdicionar.addActionListener(new AgendaAddController(agenda, this));
        botaoPesquisar = new JButton("Pesquisar", pesqImg);
        botaoPesquisar.addActionListener(new AgendaSearchController(agenda, this));
        botaoRemover = new JButton("Remover", removeImg);
        botaoRemover.addActionListener(new AgendaRemoveController(agenda, this));

        setLayout(new GridLayout(3, 2));
        add(linha1);
        add(botaoAdicionar);
        add(linha2);
        add(botaoPesquisar);
        add(new JLabel());
        add(botaoRemover);

        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAniversariante = new JMenuItem("Cadastrar Aniversariante");
        menuCadastrar.add(menuCadastrarAniversariante);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAniversariante = new JMenuItem("Pesquisar Aniversariante");
        menuPesquisar.add(menuPesquisarAniversariante);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAniversariante = new JMenuItem("Remover Aniversariante");
        menuRemover.add(menuRemoverAniversariante);

        menuCadastrarAniversariante.addActionListener(new AgendaAddController(agenda, this));
        menuPesquisarAniversariante.addActionListener(new AgendaSearchController(agenda, this));
        menuRemoverAniversariante.addActionListener(new AgendaRemoveController(agenda, this));
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);

    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUIV2ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}
