package Prinicipal;

import Arbol.*;
import static Prinicipal.Lab.getFiles;
import VisualTemplates.Creators;
import VisualTemplates.PostProfile;
import VisualTemplates.TemplateVentana;
import VisualTemplates.TreeDisplay;
import VisualTemplates.UserProfile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase que actua como la ventana principal del programa
 *
 * @author Isaac Blanco
 * 
 * 
 */
public class Ventana extends TemplateVentana {

    /**
     * Creates new form Ventana
     */
    private static Arbol arbol;
    private static Creators creators;
    private static UserProfile userProfile;
    private static PostProfile postProfile;
    private static TreeDisplay treeDisplay;
    public String currentAllSearch;

    public Ventana() {
        super();
        initComponents();
        setGUI();
    }

    public static Color menu = new Color(70, 24, 110);
    public static Color bigMenuThings = new Color(85, 57, 110);
    public static Color post2 = new Color(118, 41, 186);
    public static Color post3 = new Color(151, 52, 237);
    public static Color colorMainPost = new Color(52, 183, 241);
    public static Color backgroundGeneral = new Color(205, 238, 252);
    public static Color post1 = new Color(74, 21, 75);
    public static Color mediumPostColor = new Color(52, 183, 241);
    public static Color post4 = new Color(195, 35, 97);
    public static Color morado = new Color(231, 123, 255);
    public static Color amarillo = new Color(255, 123, 147);
    public static Font principalFont;

    @Override
    public void setGUI() {
        setFonts();
        setImages();
        setTitle("SMALL Solutions");
        menuPanel.setBackground(menu);
        mainPost.setBackground(bigMenuThings);
        smallPost1.setBackground(post3);
        smallPost2.setBackground(post2);
        smallPost3.setBackground(post3);
        smallPost4.setBackground(post2);
        mediumPost.setBackground(bigMenuThings);
        this.setBackground(backgroundGeneral);
        searchUser.setBorder(null);
        searchUser.setBackground(menu);
        searchUser.setFocusable(false);
        searchPost.setBorder(null);
        searchPost.setBackground(menu);
        TextPrompt placeholderSearchUser = new TextPrompt("Search Username", BusquedaUser);
        placeholderSearchUser.changeAlpha(0.75f);
        placeholderSearchUser.changeStyle(Font.ITALIC);
        TextPrompt placeholderSearchPost = new TextPrompt("Search Post", BusquedaPost);
        placeholderSearchPost.changeAlpha(0.75f);
        placeholderSearchPost.changeStyle(Font.ITALIC);
        TextPrompt placeholderSearchComment = new TextPrompt("Search Comment", busquedaComment);
        placeholderSearchComment.changeAlpha(0.75f);
        placeholderSearchComment.changeStyle(Font.ITALIC);
    }

    @Override
    public void setImages() {
        ImageIcon icon = new ImageIcon("Resources/icons/search.png");
        ImageIcon iconEye = new ImageIcon("Resources/icons/ojo.png");
        Image img = icon.getImage();
        Image imgEye = iconEye.getImage();
        Image newimg = img.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
        Image newimgEye = imgEye.getScaledInstance(24, 24, java.awt.Image.SCALE_SMOOTH);
        searchUser.setIcon(new ImageIcon(newimg));
        searchPost.setIcon(new ImageIcon(newimg));
        searchComment.setIcon(new ImageIcon(newimg));
        watchAllUsers.setIcon(new ImageIcon(newimgEye));
        watchAllPost.setIcon(new ImageIcon(newimgEye));
        watchAllComments.setIcon(new ImageIcon(newimgEye));
    }

    @Override
    public void setFonts() {
        // Code extracted from : https://stackoverflow.com/questions/5652344/how-can-i-use-a-custom-font-in-java by Cᴏʀʏ
        try {
            GraphicsEnvironment ge
                    = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("Menu_Font.ttf")));
        } catch (IOException | FontFormatException e) {
            //Handle exception
        }
        principalFont = new Font("Ford Antenna Regular XCnd", Font.PLAIN, 20);
        Users.setFont(principalFont);
        DeveloperSide.setFont(principalFont);
        Creators.setFont(principalFont);
        save.setFont(principalFont);
        uploadFiles.setFont(principalFont);
        DeveloperSide.setText("Tree Structure");
        Creators.setText("Creators");
        Users.setText("Home");
        save.setText("Save Tree");
        uploadFiles.setText("Upload Files");
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        possibleMatches = new javax.swing.JDialog();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        matchesUsers = new javax.swing.JList<>();
        info = new javax.swing.JLabel();
        lookUser = new javax.swing.JButton();
        CommentsView = new javax.swing.JDialog();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        postCreator = new javax.swing.JLabel();
        creator = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        body = new javax.swing.JTextArea();
        title = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        Users = new java.awt.Label();
        DeveloperSide = new java.awt.Label();
        Creators = new java.awt.Label();
        BusquedaUser = new javax.swing.JTextField();
        BusquedaPost = new javax.swing.JTextField();
        save = new java.awt.Label();
        uploadFiles = new java.awt.Label();
        searchUser = new javax.swing.JButton();
        searchPost = new javax.swing.JButton();
        watchAllUsers = new javax.swing.JLabel();
        watchAllPost = new javax.swing.JLabel();
        searchComment = new javax.swing.JButton();
        busquedaComment = new javax.swing.JTextField();
        watchAllComments = new javax.swing.JLabel();
        postPanel = new javax.swing.JPanel();
        mainPost = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainPostTitleArea = new javax.swing.JTextArea();
        jScrollPane7 = new javax.swing.JScrollPane();
        mainPostBodyArea = new javax.swing.JTextArea();
        smallPost2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        smallPostTitleArea2 = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        smallPostBodyArea2 = new javax.swing.JTextArea();
        smallPost1 = new javax.swing.JPanel();
        smallPostTitleArea = new javax.swing.JScrollPane();
        smallPostTitleArea1 = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        smallPostBodyArea1 = new javax.swing.JTextArea();
        smallPost3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        smallPostTitleArea3 = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        smallPostBodyArea3 = new javax.swing.JTextArea();
        mediumPost = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        mediumPostTitleArea = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        mediumPostBodyArea = new javax.swing.JTextArea();
        smallPost4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        smallPostTitleArea4 = new javax.swing.JTextArea();
        jScrollPane12 = new javax.swing.JScrollPane();
        smallPostBodyArea4 = new javax.swing.JTextArea();
        close = new javax.swing.JLabel();
        minimize = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(85, 57, 110));

        jScrollPane13.setBorder(null);
        jScrollPane13.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane13.setToolTipText("");

        matchesUsers.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        matchesUsers.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane13.setViewportView(matchesUsers);

        info.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        info.setForeground(new java.awt.Color(255, 255, 255));
        info.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        info.setText("Maybe you are looking for");

        lookUser.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        lookUser.setText("Look User");
        lookUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lookUserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(lookUser)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(info)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lookUser)
                .addContainerGap())
        );

        javax.swing.GroupLayout possibleMatchesLayout = new javax.swing.GroupLayout(possibleMatches.getContentPane());
        possibleMatches.getContentPane().setLayout(possibleMatchesLayout);
        possibleMatchesLayout.setHorizontalGroup(
            possibleMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        possibleMatchesLayout.setVerticalGroup(
            possibleMatchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(85, 57, 110));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Post:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Title");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Body");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("By");

        postCreator.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        postCreator.setForeground(new java.awt.Color(255, 255, 255));
        postCreator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        postCreator.setText("jLabel11");
        postCreator.setToolTipText("Watch the post");
        postCreator.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        postCreator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                postCreatorMouseClicked(evt);
            }
        });

        creator.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        creator.setForeground(new java.awt.Color(255, 255, 255));
        creator.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        creator.setText("jLabel12");
        creator.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                creatorMouseClicked(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(null);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        body.setEditable(false);
        body.setColumns(20);
        body.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        body.setLineWrap(true);
        body.setRows(5);
        jScrollPane2.setViewportView(body);

        title.setFont(new java.awt.Font("Century Gothic", 2, 12)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("jLabel13");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(postCreator, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
            .addComponent(creator, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(249, 249, 249))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel4)
                .addGap(14, 14, 14)
                .addComponent(postCreator)
                .addGap(17, 17, 17)
                .addComponent(jLabel10)
                .addGap(11, 11, 11)
                .addComponent(creator)
                .addGap(13, 13, 13)
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout CommentsViewLayout = new javax.swing.GroupLayout(CommentsView.getContentPane());
        CommentsView.getContentPane().setLayout(CommentsViewLayout);
        CommentsViewLayout.setHorizontalGroup(
            CommentsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommentsViewLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CommentsViewLayout.setVerticalGroup(
            CommentsViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CommentsViewLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        Users.setAlignment(java.awt.Label.CENTER);
        Users.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Users.setForeground(new java.awt.Color(255, 255, 255));
        Users.setText("label1");
        Users.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsersMouseClicked(evt);
            }
        });

        DeveloperSide.setAlignment(java.awt.Label.CENTER);
        DeveloperSide.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DeveloperSide.setForeground(new java.awt.Color(255, 255, 255));
        DeveloperSide.setText("label1");
        DeveloperSide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeveloperSideMouseClicked(evt);
            }
        });

        Creators.setAlignment(java.awt.Label.CENTER);
        Creators.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Creators.setForeground(new java.awt.Color(255, 255, 255));
        Creators.setText("label1");
        Creators.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CreatorsMouseClicked(evt);
            }
        });

        BusquedaPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BusquedaPostActionPerformed(evt);
            }
        });

        save.setAlignment(java.awt.Label.CENTER);
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("label1");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });

        uploadFiles.setAlignment(java.awt.Label.CENTER);
        uploadFiles.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        uploadFiles.setForeground(new java.awt.Color(255, 255, 255));
        uploadFiles.setText("label1");
        uploadFiles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                uploadFilesMouseClicked(evt);
            }
        });

        searchUser.setToolTipText("Enter the username to search");
        searchUser.setBorder(null);
        searchUser.setBorderPainted(false);
        searchUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchUser.setDoubleBuffered(true);
        searchUser.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchUserActionPerformed(evt);
            }
        });

        searchPost.setToolTipText("Search the post title");
        searchPost.setBorder(null);
        searchPost.setBorderPainted(false);
        searchPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchPost.setDoubleBuffered(true);
        searchPost.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPostActionPerformed(evt);
            }
        });

        watchAllUsers.setToolTipText("See all users");
        watchAllUsers.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        watchAllUsers.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchAllUsersMouseClicked(evt);
            }
        });

        watchAllPost.setToolTipText("See all posts");
        watchAllPost.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        watchAllPost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchAllPostMouseClicked(evt);
            }
        });

        searchComment.setBackground(new java.awt.Color(70, 24, 110));
        searchComment.setToolTipText("Search the comment title");
        searchComment.setBorder(null);
        searchComment.setBorderPainted(false);
        searchComment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        searchComment.setDoubleBuffered(true);
        searchComment.setMargin(new java.awt.Insets(0, 0, 0, 0));
        searchComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchCommentActionPerformed(evt);
            }
        });

        busquedaComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                busquedaCommentActionPerformed(evt);
            }
        });

        watchAllComments.setToolTipText("See all comments");
        watchAllComments.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        watchAllComments.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                watchAllCommentsMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(uploadFiles, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menuPanelLayout.createSequentialGroup()
                                .addComponent(searchComment, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(busquedaComment, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(watchAllComments, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(searchUser, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(searchPost, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(menuPanelLayout.createSequentialGroup()
                                        .addComponent(BusquedaPost, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(watchAllPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(menuPanelLayout.createSequentialGroup()
                                        .addComponent(BusquedaUser, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(watchAllUsers, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, menuPanelLayout.createSequentialGroup()
                                .addComponent(DeveloperSide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Users, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Creators, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BusquedaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(watchAllUsers))
                    .addComponent(searchUser, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchPost, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BusquedaPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(watchAllPost)))
                .addGap(18, 18, 18)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(searchComment, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(busquedaComment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(watchAllComments)))
                .addGap(163, 163, 163)
                .addComponent(Users, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(DeveloperSide, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(Creators, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uploadFiles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPostTitleArea.setEditable(false);
        mainPostTitleArea.setBackground(new java.awt.Color(85, 57, 110));
        mainPostTitleArea.setColumns(20);
        mainPostTitleArea.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        mainPostTitleArea.setForeground(new java.awt.Color(255, 255, 255));
        mainPostTitleArea.setRows(5);
        mainPostTitleArea.setBorder(null);
        mainPostTitleArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mainPostTitleArea.setFocusable(false);
        mainPostTitleArea.setMargin(new java.awt.Insets(0, 0, 0, 0));
        mainPostTitleArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mainPostTitleAreaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(mainPostTitleArea);

        jScrollPane7.setBorder(null);
        jScrollPane7.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane7.setToolTipText("");
        jScrollPane7.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mainPostBodyArea.setEditable(false);
        mainPostBodyArea.setBackground(new java.awt.Color(85, 57, 110));
        mainPostBodyArea.setColumns(20);
        mainPostBodyArea.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        mainPostBodyArea.setForeground(new java.awt.Color(255, 255, 255));
        mainPostBodyArea.setRows(5);
        jScrollPane7.setViewportView(mainPostBodyArea);

        javax.swing.GroupLayout mainPostLayout = new javax.swing.GroupLayout(mainPost);
        mainPost.setLayout(mainPostLayout);
        mainPostLayout.setHorizontalGroup(
            mainPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPostLayout.createSequentialGroup()
                .addGroup(mainPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPostLayout.createSequentialGroup()
                        .addGap(255, 255, 255)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPostLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPostLayout.setVerticalGroup(
            mainPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPostLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        smallPost2.setPreferredSize(new java.awt.Dimension(264, 241));

        jScrollPane3.setBorder(null);
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setToolTipText("");
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostTitleArea2.setEditable(false);
        smallPostTitleArea2.setBackground(new java.awt.Color(118, 41, 186));
        smallPostTitleArea2.setColumns(20);
        smallPostTitleArea2.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        smallPostTitleArea2.setForeground(new java.awt.Color(255, 255, 255));
        smallPostTitleArea2.setRows(5);
        smallPostTitleArea2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallPostTitleArea2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smallPostTitleArea2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(smallPostTitleArea2);

        jScrollPane9.setBorder(null);
        jScrollPane9.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane9.setToolTipText("");
        jScrollPane9.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostBodyArea2.setEditable(false);
        smallPostBodyArea2.setBackground(new java.awt.Color(118, 41, 186));
        smallPostBodyArea2.setColumns(20);
        smallPostBodyArea2.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        smallPostBodyArea2.setForeground(new java.awt.Color(255, 255, 255));
        smallPostBodyArea2.setRows(5);
        jScrollPane9.setViewportView(smallPostBodyArea2);

        javax.swing.GroupLayout smallPost2Layout = new javax.swing.GroupLayout(smallPost2);
        smallPost2.setLayout(smallPost2Layout);
        smallPost2Layout.setHorizontalGroup(
            smallPost2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(smallPost2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                    .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        smallPost2Layout.setVerticalGroup(
            smallPost2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost2Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        smallPost1.setPreferredSize(new java.awt.Dimension(264, 241));

        smallPostTitleArea.setBorder(null);
        smallPostTitleArea.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        smallPostTitleArea.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostTitleArea1.setEditable(false);
        smallPostTitleArea1.setBackground(new java.awt.Color(151, 52, 237));
        smallPostTitleArea1.setColumns(20);
        smallPostTitleArea1.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        smallPostTitleArea1.setForeground(new java.awt.Color(255, 255, 255));
        smallPostTitleArea1.setRows(5);
        smallPostTitleArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallPostTitleArea1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smallPostTitleArea1MouseClicked(evt);
            }
        });
        smallPostTitleArea.setViewportView(smallPostTitleArea1);

        jScrollPane10.setBorder(null);
        jScrollPane10.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane10.setToolTipText("");
        jScrollPane10.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostBodyArea1.setEditable(false);
        smallPostBodyArea1.setBackground(new java.awt.Color(151, 52, 237));
        smallPostBodyArea1.setColumns(20);
        smallPostBodyArea1.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        smallPostBodyArea1.setForeground(new java.awt.Color(255, 255, 255));
        smallPostBodyArea1.setRows(5);
        jScrollPane10.setViewportView(smallPostBodyArea1);

        javax.swing.GroupLayout smallPost1Layout = new javax.swing.GroupLayout(smallPost1);
        smallPost1.setLayout(smallPost1Layout);
        smallPost1Layout.setHorizontalGroup(
            smallPost1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smallPost1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(smallPost1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(smallPostTitleArea, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        smallPost1Layout.setVerticalGroup(
            smallPost1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(smallPostTitleArea, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        smallPost3.setBackground(new java.awt.Color(118, 41, 186));

        jScrollPane4.setBorder(null);
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setToolTipText("");
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostTitleArea3.setEditable(false);
        smallPostTitleArea3.setBackground(new java.awt.Color(151, 52, 237));
        smallPostTitleArea3.setColumns(20);
        smallPostTitleArea3.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        smallPostTitleArea3.setForeground(new java.awt.Color(255, 255, 255));
        smallPostTitleArea3.setRows(5);
        smallPostTitleArea3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallPostTitleArea3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smallPostTitleArea3MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(smallPostTitleArea3);

        jScrollPane8.setBorder(null);
        jScrollPane8.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane8.setToolTipText("");
        jScrollPane8.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostBodyArea3.setEditable(false);
        smallPostBodyArea3.setBackground(new java.awt.Color(151, 52, 237));
        smallPostBodyArea3.setColumns(20);
        smallPostBodyArea3.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        smallPostBodyArea3.setForeground(new java.awt.Color(255, 255, 255));
        smallPostBodyArea3.setRows(5);
        jScrollPane8.setViewportView(smallPostBodyArea3);

        javax.swing.GroupLayout smallPost3Layout = new javax.swing.GroupLayout(smallPost3);
        smallPost3.setLayout(smallPost3Layout);
        smallPost3Layout.setHorizontalGroup(
            smallPost3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost3Layout.createSequentialGroup()
                .addGroup(smallPost3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, smallPost3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(smallPost3Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane4)))
                .addContainerGap())
        );
        smallPost3Layout.setVerticalGroup(
            smallPost3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane5.setBorder(null);
        jScrollPane5.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane5.setToolTipText("");
        jScrollPane5.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mediumPostTitleArea.setEditable(false);
        mediumPostTitleArea.setBackground(new java.awt.Color(85, 57, 110));
        mediumPostTitleArea.setColumns(20);
        mediumPostTitleArea.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        mediumPostTitleArea.setForeground(new java.awt.Color(255, 255, 255));
        mediumPostTitleArea.setRows(5);
        mediumPostTitleArea.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mediumPostTitleArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mediumPostTitleAreaMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(mediumPostTitleArea);

        jScrollPane11.setBorder(null);
        jScrollPane11.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane11.setToolTipText("");
        jScrollPane11.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        mediumPostBodyArea.setEditable(false);
        mediumPostBodyArea.setBackground(new java.awt.Color(85, 57, 110));
        mediumPostBodyArea.setColumns(20);
        mediumPostBodyArea.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        mediumPostBodyArea.setForeground(new java.awt.Color(255, 255, 255));
        mediumPostBodyArea.setRows(5);
        jScrollPane11.setViewportView(mediumPostBodyArea);

        javax.swing.GroupLayout mediumPostLayout = new javax.swing.GroupLayout(mediumPost);
        mediumPost.setLayout(mediumPostLayout);
        mediumPostLayout.setHorizontalGroup(
            mediumPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mediumPostLayout.createSequentialGroup()
                .addContainerGap(188, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
            .addGroup(mediumPostLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mediumPostLayout.setVerticalGroup(
            mediumPostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mediumPostLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(70, Short.MAX_VALUE))
        );

        jScrollPane6.setBorder(null);
        jScrollPane6.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane6.setToolTipText("");
        jScrollPane6.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostTitleArea4.setEditable(false);
        smallPostTitleArea4.setBackground(new java.awt.Color(118, 41, 186));
        smallPostTitleArea4.setColumns(20);
        smallPostTitleArea4.setFont(new java.awt.Font("Nirmala UI Semilight", 3, 12)); // NOI18N
        smallPostTitleArea4.setForeground(new java.awt.Color(255, 255, 255));
        smallPostTitleArea4.setRows(5);
        smallPostTitleArea4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        smallPostTitleArea4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                smallPostTitleArea4MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(smallPostTitleArea4);

        jScrollPane12.setBorder(null);
        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setToolTipText("");
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        smallPostBodyArea4.setEditable(false);
        smallPostBodyArea4.setBackground(new java.awt.Color(118, 41, 186));
        smallPostBodyArea4.setColumns(20);
        smallPostBodyArea4.setFont(new java.awt.Font("Century Gothic", 2, 14)); // NOI18N
        smallPostBodyArea4.setForeground(new java.awt.Color(255, 255, 255));
        smallPostBodyArea4.setRows(5);
        jScrollPane12.setViewportView(smallPostBodyArea4);

        javax.swing.GroupLayout smallPost4Layout = new javax.swing.GroupLayout(smallPost4);
        smallPost4.setLayout(smallPost4Layout);
        smallPost4Layout.setHorizontalGroup(
            smallPost4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(smallPost4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(19, 19, 19))
        );
        smallPost4Layout.setVerticalGroup(
            smallPost4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(smallPost4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout postPanelLayout = new javax.swing.GroupLayout(postPanel);
        postPanel.setLayout(postPanelLayout);
        postPanelLayout.setHorizontalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPanelLayout.createSequentialGroup()
                .addGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mainPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, postPanelLayout.createSequentialGroup()
                        .addGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(mediumPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(postPanelLayout.createSequentialGroup()
                                .addComponent(smallPost1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(smallPost2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(smallPost4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(smallPost3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        postPanelLayout.setVerticalGroup(
            postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(postPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(mainPost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(smallPost1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smallPost2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smallPost3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(postPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mediumPost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(smallPost4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        close.setText("X");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        minimize.setText("-");
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(postPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(minimize)
                .addGap(10, 10, 10)
                .addComponent(close)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(close)
                            .addComponent(minimize)))
                    .addComponent(postPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BusquedaPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BusquedaPostActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BusquedaPostActionPerformed

    private void searchUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchUserActionPerformed
        // TODO add your handling code here:
        currentAllSearch = "User";
        String text = BusquedaUser.getText();
        User user = searchUser(text);
        int ID = 0;
        try {
            Integer.parseInt(BusquedaUser.getText());
        } catch (NumberFormatException e) {
            ID = -1;
        }
        if (user == null && ID == -1) {
            ListaEnlazada<User> matches = arbol.matchPosibbleUsers(text.toLowerCase());
            if (matches.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ERROR", "Usuario no encontrado", JOptionPane.ERROR_MESSAGE);
                return;
            }
            setPossibleQuery(matches);
            return;
        }
        userProfile = new UserProfile();
        userProfile.setVisible(true);
        userProfile.setUsuario(user);
    }//GEN-LAST:event_searchUserActionPerformed

    private void searchPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPostActionPerformed
        // TODO add your handling code here:
        currentAllSearch = "Post";
        String searchTag = BusquedaPost.getText();
        int id = 0;
        try {
            id = Integer.parseInt(searchTag);
        } catch (NumberFormatException e) {
            System.out.println(e);
            id = -1;
        }
        if (id == -1) {
            searchPost(searchTag);
        } else {
            searchPost(id);
        }
    }//GEN-LAST:event_searchPostActionPerformed

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void minimizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeMouseClicked
        // TODO add your handling code here:
        this.setState(Ventana.ICONIFIED);
    }//GEN-LAST:event_minimizeMouseClicked

    private void mainPostTitleAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainPostTitleAreaMouseClicked
        // TODO add your handling code here:
        searchPost(mainPostTitleArea.getText());
    }//GEN-LAST:event_mainPostTitleAreaMouseClicked

    private void smallPostTitleArea1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallPostTitleArea1MouseClicked
        // TODO add your handling code here:
        searchPost(smallPostTitleArea1.getText());
    }//GEN-LAST:event_smallPostTitleArea1MouseClicked

    private void smallPostTitleArea2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallPostTitleArea2MouseClicked
        // TODO add your handling code here:
        searchPost(smallPostTitleArea2.getText());
    }//GEN-LAST:event_smallPostTitleArea2MouseClicked

    private void smallPostTitleArea4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallPostTitleArea4MouseClicked
        // TODO add your handling code here:
        searchPost(smallPostTitleArea4.getText());
    }//GEN-LAST:event_smallPostTitleArea4MouseClicked

    private void smallPostTitleArea3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_smallPostTitleArea3MouseClicked
        // TODO add your handling code here:
        searchPost(smallPostTitleArea3.getText());
    }//GEN-LAST:event_smallPostTitleArea3MouseClicked

    private void mediumPostTitleAreaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mediumPostTitleAreaMouseClicked
        // TODO add your handling code here:
        searchPost(mediumPostTitleArea.getText());
    }//GEN-LAST:event_mediumPostTitleAreaMouseClicked

    private void watchAllUsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchAllUsersMouseClicked
        // TODO add your handling code here:
        currentAllSearch = "User";
        setAllUsers();
    }//GEN-LAST:event_watchAllUsersMouseClicked

    private void lookUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lookUserActionPerformed
        // TODO add your handling code here:
        String titleS = matchesUsers.getSelectedValue();
        if (currentAllSearch.equals("User")) {
            User user = arbol.busquedaUser(titleS.toLowerCase());
            lookUser.setText("Look User");
            userProfile = new UserProfile();
            userProfile.setVisible(true);
            userProfile.setUsuario(user);
        } else if (currentAllSearch.equals("Post")) {
            Post post = arbol.getPost(titleS);
            User user = arbol.getUserByPost(post.getTitle());
            lookUser.setText("Look Post");
            postProfile = new PostProfile();
            postProfile.setVisible(true);
            postProfile.setPost(post, user);
        } else {
            Comment c = arbol.getComment(titleS);
            Post p = arbol.getPost(c.getPostId());
            CommentsView.setTitle("SMALL SOLUTIONS");
            creator.setText(c.getEmail());
            title.setText(c.getName());
            body.setText(c.getBody());
            postCreator.setText(p.getTitle());
            CommentsView.setSize(new Dimension(1168, 400));
            CommentsView.setVisible(true);
            CommentsView.setResizable(true);
            lookUser.setText("Look Comment");
        }
    }//GEN-LAST:event_lookUserActionPerformed

    private void watchAllPostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchAllPostMouseClicked
        // TODO add your handling code here:
        currentAllSearch = "Post";
        ListaEnlazada<Post> posts = new ListaEnlazada();
        for (Object nodo : arbol.getRaiz().getPosts()) {
            User user = (User) nodo;
            for (Object n : user.getPosts()) {
                Post p = (Post) n;
                posts.add(p);
            }
        }
        setAllPost(posts);
    }//GEN-LAST:event_watchAllPostMouseClicked

    private void uploadFilesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_uploadFilesMouseClicked
        // TODO add your handling code here:
        File[] files = null;
        JFileChooser chooser = new JFileChooser();
        chooser.setMultiSelectionEnabled(true);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "*.txt,*.csv", "txt", "csv");
        chooser.setFileFilter(filter);
        int returnValue = chooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            files = chooser.getSelectedFiles();
        }
        try {
            while (!files[0].getName().contains(".csv") && Lab.createTree(files) == null) {
                if (!files[0].getName().contains(".csv") && files.length == 1) {
                    JOptionPane.showMessageDialog(null, "El archivo que contiene el arbol serializado debe ser .csv", "Archivo con extension invalida", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivos con nombre incorrecto, por favor maneje los nombres Comment,Users,Posts en formato .txt", "Error de ingreso de archivo", JOptionPane.ERROR_MESSAGE);
                }
                files = getFiles();
            }
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(files.length == 1){
            arbol = Serializador.recover(files[0].getAbsolutePath());
        }else{
            try {
                arbol = Lab.createTree(files);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_uploadFilesMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
        try {
            // TODO add your handling code here:
            Serializador.serialize(arbol);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveMouseClicked

    private void CreatorsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CreatorsMouseClicked
        // TODO add your handling code here:
        creators = new Creators();
        creators.setVisible(true);
    }//GEN-LAST:event_CreatorsMouseClicked

    private void DeveloperSideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeveloperSideMouseClicked
        // TODO add your handling code here:
        treeDisplay = new TreeDisplay(arbol, this);
        treeDisplay.setVisible(true);
    }//GEN-LAST:event_DeveloperSideMouseClicked

    private void UsersMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsersMouseClicked
        // TODO add your handling code here:
        System.out.println("ESTAS EN CASA :3");
    }//GEN-LAST:event_UsersMouseClicked

    private void searchCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchCommentActionPerformed
        // TODO add your handling code here:
        currentAllSearch = "Comment";
        Comment c = searchComment();
        if(c == null){
            return;
        }
        Post post = arbol.getPost(c.getPostId());
        CommentsView.setTitle("SMALL SOLUTIONS");
        creator.setText(c.getEmail());
        title.setText(c.getName());
        body.setText(c.getBody());
        postCreator.setText(post.getTitle());
        CommentsView.setSize(new Dimension(1168, 400));
        CommentsView.setVisible(true);
        CommentsView.setResizable(false);
        lookUser.setText("Look the Comment");
    }//GEN-LAST:event_searchCommentActionPerformed

    private void busquedaCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_busquedaCommentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_busquedaCommentActionPerformed

    private void watchAllCommentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_watchAllCommentsMouseClicked
        // TODO add your handling code here:
        currentAllSearch = "Comments";
        ListaEnlazada<Comment> comment = new ListaEnlazada();
        for (Object nodo : arbol.getRaiz().getPosts()) {
            User user = (User) nodo;
            for (Object n : user.getPosts()) {
                Post post = (Post) n;
                for (Object nod : post.getComments()) {
                    Comment c = (Comment) nod;
                    comment.add(c);
                }
            }
        }
        setAllComments(comment);
    }//GEN-LAST:event_watchAllCommentsMouseClicked

    private void postCreatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_postCreatorMouseClicked
        // TODO add your handling code here:
        searchPost(postCreator.getText());
    }//GEN-LAST:event_postCreatorMouseClicked

    private void creatorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_creatorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_creatorMouseClicked

    public void setArbol(Arbol arbol) {
        Ventana.arbol = arbol;
        getPostForShowing();
    }

    public static Arbol getArbol() {
        return arbol;
    }

    /**
     * Metodo que se encarga de la busqueda de un User para ser desplegado en pantalla
     *
     * @param user Nombre de usuario del User a buscar
     * @return u {@link User} Usuario a mostrar en pantalla
     */
    public User searchUser(String user) {
        if (user.isEmpty()) {
            return null;
        }
        int userID = 0;
        User u;
        try {
            userID = Integer.parseInt(user);
        } catch (NumberFormatException e) {
            System.out.println(e);
            userID = -1;
        }
        if (userID == -1) {
            u = arbol.busquedaUser(user.toLowerCase());
        } else {
            u = arbol.busquedaUser(userID);
        }
        return u;
    }

    /**
     * Metodo que se encarga de la busqueda de un Comment para ser desplegado en pantalla
     *
     * @return comment {@link Comment} Comentario a mostrar en pantalla
     */
    public Comment searchComment() {
        String title = busquedaComment.getText();
        int ID;
        Comment comment;
        try {
            ID = Integer.parseInt(title);
        } catch (NumberFormatException e) {
            ID = -1;
        }
        if (ID == -1) {
            comment = arbol.getComment(title);
        } else {
            comment = arbol.getComment(ID);
        }
        if (comment == null) {
            JOptionPane.showMessageDialog(null, "ERROR", "Comentario no encontrado", JOptionPane.ERROR_MESSAGE);
            return null;
        }
        return comment;
    }

    /**
     * Metodo que se encarga de la busqueda de un Post para ser desplegado en pantalla a partir de su Titulo
     *
     * @param title Titulo del Post a buscar
     */
    public void searchPost(String title) {
        Post p = arbol.getPost(title);
        if (p != null) {
            postProfile = new PostProfile();
            postProfile.setPost(p, arbol.getUserByPost(title));
            postProfile.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null, "ERROR", "Post no encontrado", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo que se encarga de la busqueda de un Post para ser desplegado en pantalla a partir de su ID
     *
     * @param id ID del post a buscar
     */
    public void searchPost(int id) {
        Post p = arbol.getPost(id);
        if (p != null) {
            postProfile = new PostProfile();
            postProfile.setPost(p, arbol.getUserByPost(id));
            postProfile.setVisible(true);
            return;
        }
        JOptionPane.showMessageDialog(null, "ERROR", "Post no encontrado", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Metodo que se encarga de mostrar todos los {@link Nodo} de tipo {@link Post} en Pantalla
     *
     * @param posts {@code LinkedList<Post>} que contiene todos los Post del Arbol
     */
    public void setAllPost(ListaEnlazada<Post> posts) {
        possibleMatches.setTitle("SMALL Solutions");
        possibleMatches.setResizable(false);
        possibleMatches.setVisible(true);
        info.setText("All the Post are");
        lookUser.setText("Look Post");
        DefaultListModel model = new DefaultListModel();
        matchesUsers.setModel(model);
        for (Post p : posts) {
            model.addElement(p.getTitle());
        }
        possibleMatches.setSize(new Dimension(400, 500));
    }

    /**
     * Metodo que se encarga de mostrar en pantalla todos los {@link User} que contienen las coincidencias de nombre
     *
     * @param matches {@code LinkedList<User>} que contiene todas las coincidencias de los User
     */
    public void setPossibleQuery(ListaEnlazada<User> matches) {
        possibleMatches.setTitle("SMALL Solutions");
        possibleMatches.setResizable(false);
        possibleMatches.setVisible(true);
        info.setText("Maybe you are looking for");
        DefaultListModel model = new DefaultListModel();
        matchesUsers.setModel(model);
        for (User m : matches) {
            model.addElement(m.getUsername());
        }
        possibleMatches.setSize(new Dimension(400, 500));
    }

    /**
     * Metodo que se encarga de mostrar todos los {@link Nodo} de tipo {@link User} en Pantalla
     */
    public void setAllUsers() {
        possibleMatches.setTitle("SMALL Solutions");
        lookUser.setText("Look User");
        possibleMatches.setResizable(false);
        possibleMatches.setVisible(true);
        info.setText("All the users in the plataform");

        DefaultListModel model = new DefaultListModel();
        matchesUsers.setModel(model);
        for (Object n : arbol.getRaiz().getPosts()) {
            User user = (User) n;
            model.addElement(user.getUsername());
        }
        possibleMatches.setSize(new Dimension(400, 500));
    }

    /**
     * Metodo que se encarga de mostrar todos los {@link Nodo} de tipo {@link Comment} en Pantalla
     *
     * @param c {@code LinkedList<Comment>} que contiene todos los {@link Nodo} de tipo {@link Comment} del Arbol
     */
    public void setAllComments(ListaEnlazada<Comment> c) {
        possibleMatches.setTitle("SMALL Solutions");
        possibleMatches.setResizable(false);
        possibleMatches.setVisible(true);
        lookUser.setText("Look Comments");
        info.setText("All the comments in the plataform");
        DefaultListModel model = new DefaultListModel();
        matchesUsers.setModel(model);
        for (Comment co : c) {
            model.addElement(co.getName());
        }
        possibleMatches.setSize(new Dimension(400, 500));
    }

    /**
     * Metodo que se encarga de mostrar algunos de los {@link Nodo} de tipo {@link Post} en el menu lateral derecho
     */
    public void getPostForShowing() {
        ListaEnlazada<Post> lista = Lab.getRandomPost(arbol);
        if (lista.size() >= 6) {
            setAllText(lista);
        } else {
            System.out.println("ERROR");
        }
    }

    /**
     * Metodo que se encarga de inicializar los valores de los TextArea del panel derecho
     *
     * @param info {@code LinkedList<Post>} Que tiene todos los Post para ser mostrados
     */
    public void setAllText(ListaEnlazada<Post> info) {
        mainPostTitleArea.append(info.get(0).getTitle());
        mainPostTitleArea.setLineWrap(true);
        mainPostBodyArea.append(info.get(0).getBody());
        mainPostBodyArea.setLineWrap(true);
        smallPostTitleArea1.append(info.get(1).getTitle());
        smallPostTitleArea1.setLineWrap(true);
        smallPostBodyArea1.append(info.get(1).getTitle());
        smallPostBodyArea1.setLineWrap(true);
        smallPostTitleArea2.append(info.get(2).getTitle());
        smallPostTitleArea2.setLineWrap(true);
        smallPostBodyArea2.append(info.get(2).getBody());
        smallPostBodyArea2.setLineWrap(true);
        smallPostTitleArea3.append(info.get(3).getTitle());
        smallPostTitleArea3.setLineWrap(true);
        smallPostBodyArea3.append(info.get(3).getBody());
        smallPostBodyArea3.setLineWrap(true);
        smallPostTitleArea4.append(info.get(4).getTitle());
        smallPostTitleArea4.setLineWrap(true);
        smallPostBodyArea4.append(info.get(4).getBody());
        smallPostBodyArea4.setLineWrap(true);
        mediumPostTitleArea.append(info.get(5).getTitle());
        mediumPostTitleArea.setLineWrap(true);
        mediumPostBodyArea.append(info.get(5).getBody());
        mediumPostBodyArea.setLineWrap(true);
    }

    public void setCurrentAllSearch(String currentAllSearch) {
        this.currentAllSearch = currentAllSearch;
    }

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BusquedaPost;
    private javax.swing.JTextField BusquedaUser;
    private javax.swing.JDialog CommentsView;
    private java.awt.Label Creators;
    private java.awt.Label DeveloperSide;
    private java.awt.Label Users;
    private javax.swing.JTextArea body;
    private javax.swing.JTextField busquedaComment;
    private javax.swing.JLabel close;
    private javax.swing.JLabel creator;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JButton lookUser;
    private javax.swing.JPanel mainPost;
    private javax.swing.JTextArea mainPostBodyArea;
    private javax.swing.JTextArea mainPostTitleArea;
    private javax.swing.JList<String> matchesUsers;
    private javax.swing.JPanel mediumPost;
    private javax.swing.JTextArea mediumPostBodyArea;
    private javax.swing.JTextArea mediumPostTitleArea;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JLabel minimize;
    private javax.swing.JDialog possibleMatches;
    private javax.swing.JLabel postCreator;
    private javax.swing.JPanel postPanel;
    private java.awt.Label save;
    private javax.swing.JButton searchComment;
    private javax.swing.JButton searchPost;
    private javax.swing.JButton searchUser;
    private javax.swing.JPanel smallPost1;
    private javax.swing.JPanel smallPost2;
    private javax.swing.JPanel smallPost3;
    private javax.swing.JPanel smallPost4;
    private javax.swing.JTextArea smallPostBodyArea1;
    private javax.swing.JTextArea smallPostBodyArea2;
    private javax.swing.JTextArea smallPostBodyArea3;
    private javax.swing.JTextArea smallPostBodyArea4;
    private javax.swing.JScrollPane smallPostTitleArea;
    private javax.swing.JTextArea smallPostTitleArea1;
    private javax.swing.JTextArea smallPostTitleArea2;
    private javax.swing.JTextArea smallPostTitleArea3;
    private javax.swing.JTextArea smallPostTitleArea4;
    private javax.swing.JLabel title;
    private java.awt.Label uploadFiles;
    private javax.swing.JLabel watchAllComments;
    private javax.swing.JLabel watchAllPost;
    private javax.swing.JLabel watchAllUsers;
    // End of variables declaration//GEN-END:variables

}
