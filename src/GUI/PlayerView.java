/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import NapakalakiGame.Player;
import NapakalakiGame.CultistPlayer;
import NapakalakiGame.Napakalaki;
import NapakalakiGame.Treasure;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author manuel
 */
public class PlayerView extends javax.swing.JPanel {
    private Player playerModel;
    private Napakalaki napakalakiModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    private ArrayList<Treasure> getSelectedTreasures(JPanel aPanel) {

    TreasureView tv;
    ArrayList<Treasure> output = new ArrayList();
    for (Component c : aPanel.getComponents()) {
        tv = (TreasureView) c;
        if ( tv.isSelected() )
            output.add ( tv.getTreasure() );
    }
    return output;
    }
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel = n;
    }
    
    public void setPlayer(Player p){
        playerModel = p;
        name.setText(p.getName());
        nivel.setText(Integer.toString(p.getLevels()));
        nivel_combate.setText(Integer.toString(p.getCombatLevel()));
        num_sectarios.setText(Integer.toString(CultistPlayer.getTotalCultistPlayers()));
        
        if(p instanceof CultistPlayer)
            ser_sectario.setText("Eres Sectario");
        else
            ser_sectario.setText("No eres Sectario");
        
        this.fillTreasurePanel(panel_visibles ,playerModel.getVisibleTreasures());
        this.fillTreasurePanel(panel_hidden ,playerModel.getHiddenTreasures());
        repaint();
        revalidate();
        
    }
    
    private void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
    // Se elimina la información antigua, si la hubiera
    aPanel.removeAll();
    // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
    // al panel
    for (Treasure t : aList) {
        TreasureView aTreasureView = new TreasureView();
        aTreasureView.setTreasure (t);
        aTreasureView.setVisible (true);
        aPanel.add (aTreasureView);
    }
    // Se fuerza la actualización visual del panel
    aPanel.repaint();
    aPanel.revalidate();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        name = new javax.swing.JLabel();
        nivel = new javax.swing.JLabel();
        nivel_combate = new javax.swing.JLabel();
        texto_nivel = new javax.swing.JLabel();
        text_nivel_combate = new javax.swing.JLabel();
        ser_sectario = new javax.swing.JLabel();
        text_num_sectarios = new javax.swing.JLabel();
        num_sectarios = new javax.swing.JLabel();
        panel_visibles = new javax.swing.JPanel();
        texto_tesoros_visibles = new javax.swing.JLabel();
        panel_hidden = new javax.swing.JPanel();
        texto_tesoros_ocultos = new javax.swing.JLabel();
        button_make_visible = new javax.swing.JButton();
        button_discard = new javax.swing.JButton();
        button_discard_all = new javax.swing.JButton();

        setBackground(new java.awt.Color(10, 241, 205));

        name.setFont(new java.awt.Font("Cantarell", 0, 24)); // NOI18N
        name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        name.setText("jLabel1");

        nivel.setText("jLabel1");

        nivel_combate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nivel_combate.setText("jLabel1");

        texto_nivel.setText("Nivel:");
        texto_nivel.setToolTipText("");

        text_nivel_combate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        text_nivel_combate.setText("Nivel de Combate:");

        ser_sectario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ser_sectario.setText("jLabel1");

        text_num_sectarios.setText("Sectarios en partida:");

        num_sectarios.setText("jLabel2");

        panel_visibles.setBorder(new javax.swing.border.MatteBorder(null));

        texto_tesoros_visibles.setText("Tesoros Visibles");
        panel_visibles.add(texto_tesoros_visibles);

        panel_hidden.setBorder(new javax.swing.border.MatteBorder(null));

        texto_tesoros_ocultos.setText("Tesoros Ocultos");
        panel_hidden.add(texto_tesoros_ocultos);

        button_make_visible.setText("Make Visible");
        button_make_visible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_make_visibleActionPerformed(evt);
            }
        });

        button_discard.setText("Discard treasures");
        button_discard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_discardActionPerformed(evt);
            }
        });

        button_discard_all.setText("Discard All Treasures");
        button_discard_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_discard_allActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_nivel_combate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nivel_combate, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(111, 111, 111)
                                .addComponent(ser_sectario, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(panel_visibles, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(text_num_sectarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_make_visible)
                                    .addComponent(button_discard))
                                .addGap(137, 137, 137))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button_discard_all)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(texto_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(num_sectarios, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panel_hidden, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nivel_combate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(texto_nivel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(text_nivel_combate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(text_num_sectarios, javax.swing.GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
                        .addComponent(ser_sectario))
                    .addComponent(num_sectarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(button_make_visible)
                        .addGap(68, 68, 68)
                        .addComponent(button_discard)
                        .addGap(61, 61, 61)
                        .addComponent(button_discard_all)
                        .addGap(80, 80, 80))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panel_hidden, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panel_visibles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void button_make_visibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_make_visibleActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(panel_hidden);
        napakalakiModel.makeTreasuresVisible(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_button_make_visibleActionPerformed

    private void button_discardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_discardActionPerformed
        ArrayList<Treasure> selHidden = getSelectedTreasures(panel_hidden);
        napakalakiModel.discardHiddenTreasures(selHidden);
        setPlayer(napakalakiModel.getCurrentPlayer());
    }//GEN-LAST:event_button_discardActionPerformed

    private void button_discard_allActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_discard_allActionPerformed
        napakalakiModel.getCurrentPlayer().discardAllTreasures();
        setPlayer(napakalakiModel.getCurrentPlayer());
        
    }//GEN-LAST:event_button_discard_allActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_discard;
    private javax.swing.JButton button_discard_all;
    private javax.swing.JButton button_make_visible;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nivel;
    private javax.swing.JLabel nivel_combate;
    private javax.swing.JLabel num_sectarios;
    private javax.swing.JPanel panel_hidden;
    private javax.swing.JPanel panel_visibles;
    private javax.swing.JLabel ser_sectario;
    private javax.swing.JLabel text_nivel_combate;
    private javax.swing.JLabel text_num_sectarios;
    private javax.swing.JLabel texto_nivel;
    private javax.swing.JLabel texto_tesoros_ocultos;
    private javax.swing.JLabel texto_tesoros_visibles;
    // End of variables declaration//GEN-END:variables
}
