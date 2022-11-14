package br.ufpb;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AgendaGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon artAniversario = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"aniversarioMemeImg.png ");
    ImageIcon addImg  = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"adicionarImg.png");
    ImageIcon pesqImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"pesquisarImg.png");
    ImageIcon removeImg = new ImageIcon("src"+File.separator+"main"+File.separator+"resources"+ File.separator+"imgs"+File.separator+"removerImg.png");
    JButton botaoAdicionar, botaoPesquisar, botaoRemover;
    AgendaInterface agenda = new MinhaAgenda();

    public AgendaGUI() {
        setTitle("Agenda de Aniversários");
        setSize(700, 550);
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
    }

    public static void main(String[] args) {
        JFrame janela = new AgendaGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

}
