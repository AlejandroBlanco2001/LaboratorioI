/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VisualTemplates;

import Arbol.Comment;
import Arbol.Nodo;
import Arbol.Post;
import Arbol.User;
import Prinicipal.Ventana;
import javax.swing.DefaultListModel;

/**
 *
 * @author alexz
 */
public class PostProfile extends TemplateVentana {

    private static UserProfile userProfile;
    
    /**
     * Creates new form PostProfile
     */
    private Post post;
    private User username;
    private final DefaultListModel model;

    public PostProfile() {
        super();
        initComponents();
        dispose();
        setUndecorated(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        model = new DefaultListModel();
    }

    @Override
    public void setGUI() {
        setTitle("SMALL Solutions");
        titlePost.setText(post.getTitle());
        titlePost.setFont(Ventana.principalFont);
        authorPost.setText(username.getUsername());
        authorPost.setFont(Ventana.principalFont);
        body.append(post.getBody());
        body.setLineWrap(true);
        CommentsText.setFont(Ventana.principalFont);
        commentPanel.setBackground(Ventana.mediumPostColor);
        postPart.setBackground(Ventana.post3);
        CommentsList.setModel(model);
        numberComments.setText("# Comments : " + post.getComments().size());
        fillModel();
    }

    public void fillModel() {
        int cont = 1;
        for (Nodo nodo : post.getComments()) {
            Comment c = (Comment) nodo;
            model.addElement(cont + " - By: " + c.getName() + " : " + c.getBody() + " \n | Contact Adress " + c.getEmail());
            cont++;
        }
    }

    public void setPost(Post p, User username) {
        this.post = p;
        this.username = username;
        setGUI();
    }

    @Override
    public void setFonts() {
    }

    @Override
    public void setImages() {
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        commentPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        CommentsList = new javax.swing.JList<>();
        CommentsText = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        close1 = new javax.swing.JLabel();
        numberComments = new javax.swing.JLabel();
        postPart = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        titlePost = new javax.swing.JLabel();
        authorPost = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane2.setBorder(null);

        CommentsList.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        CommentsList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        CommentsList.setToolTipText("");
        jScrollPane2.setViewportView(CommentsList);

        CommentsText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CommentsText.setText("Comments");

        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        close1.setText("-");
        close1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                close1MouseClicked(evt);
            }
        });

        numberComments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout commentPanelLayout = new javax.swing.GroupLayout(commentPanel);
        commentPanel.setLayout(commentPanelLayout);
        commentPanelLayout.setHorizontalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close1)
                .addGap(18, 18, 18)
                .addComponent(close)
                .addGap(18, 18, 18))
            .addGroup(commentPanelLayout.createSequentialGroup()
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(commentPanelLayout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(commentPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(CommentsText, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numberComments, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        commentPanelLayout.setVerticalGroup(
            commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, commentPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(close)
                    .addComponent(close1))
                .addGap(32, 32, 32)
                .addGroup(commentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CommentsText)
                    .addComponent(numberComments))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jScrollPane3.setBorder(null);

        body.setEditable(false);
        body.setColumns(20);
        body.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        body.setRows(5);
        body.setWrapStyleWord(true);
        jScrollPane3.setViewportView(body);

        titlePost.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titlePost.setText("jLabel1");

        authorPost.setText("jLabel1");
        authorPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                authorPostMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout postPartLayout = new javax.swing.GroupLayout(postPart);
        postPart.setLayout(postPartLayout);
        postPartLayout.setHorizontalGroup(
            postPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPartLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, postPartLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(postPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(postPartLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(authorPost))
                    .addComponent(titlePost, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
        );
        postPartLayout.setVerticalGroup(
            postPartLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPartLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(titlePost)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorPost)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(postPart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(commentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(commentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(postPart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeMouseClicked

    private void authorPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_authorPostMouseClicked
        // TODO add your handling code here:
        userProfile = new UserProfile();
        userProfile.setUsuario(username);
        userProfile.setVisible(true);
    }//GEN-LAST:event_authorPostMouseClicked

    private void close1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_close1MouseClicked
        // TODO add your handling code here:
        this.setState(PostProfile.ICONIFIED);
    }//GEN-LAST:event_close1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostProfile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PostProfile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> CommentsList;
    private javax.swing.JLabel CommentsText;
    private javax.swing.JLabel authorPost;
    private javax.swing.JTextArea body;
    private javax.swing.JLabel close;
    private javax.swing.JLabel close1;
    private javax.swing.JPanel commentPanel;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel numberComments;
    private javax.swing.JPanel postPart;
    private javax.swing.JLabel titlePost;
    // End of variables declaration//GEN-END:variables

}
