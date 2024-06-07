namespace OficinaTramites
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            txtCI = new TextBox();
            txtNombres = new TextBox();
            txtPrimerApellido = new TextBox();
            txtSegundoApellido = new TextBox();
            txtTitulo = new TextBox();
            btnEmitirTitulo = new Button();
            label1 = new Label();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            label5 = new Label();
            lblinfo = new Label();
            SuspendLayout();
            // 
            // txtCI
            // 
            txtCI.Location = new Point(190, 116);
            txtCI.Name = "txtCI";
            txtCI.Size = new Size(150, 27);
            txtCI.TabIndex = 0;
            // 
            // txtNombres
            // 
            txtNombres.Location = new Point(452, 123);
            txtNombres.Name = "txtNombres";
            txtNombres.Size = new Size(234, 27);
            txtNombres.TabIndex = 1;
            // 
            // txtPrimerApellido
            // 
            txtPrimerApellido.Location = new Point(190, 207);
            txtPrimerApellido.Name = "txtPrimerApellido";
            txtPrimerApellido.Size = new Size(173, 27);
            txtPrimerApellido.TabIndex = 2;
            // 
            // txtSegundoApellido
            // 
            txtSegundoApellido.Location = new Point(511, 208);
            txtSegundoApellido.Name = "txtSegundoApellido";
            txtSegundoApellido.Size = new Size(175, 27);
            txtSegundoApellido.TabIndex = 3;            
            // 
            // txtTitulo
            // 
            txtTitulo.Location = new Point(286, 277);
            txtTitulo.Name = "txtTitulo";
            txtTitulo.Size = new Size(228, 27);
            txtTitulo.TabIndex = 4;
            // 
            // btnEmitirTitulo
            // 
            btnEmitirTitulo.Location = new Point(296, 363);
            btnEmitirTitulo.Name = "btnEmitirTitulo";
            btnEmitirTitulo.Size = new Size(209, 29);
            btnEmitirTitulo.TabIndex = 5;
            btnEmitirTitulo.Text = "Emitir Titulo";
            btnEmitirTitulo.UseVisualStyleBackColor = true;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(68, 119);
            label1.Name = "label1";
            label1.Size = new Size(25, 20);
            label1.TabIndex = 6;
            label1.Text = "CI:";
            
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(373, 123);
            label2.Name = "label2";
            label2.Size = new Size(73, 20);
            label2.TabIndex = 7;
            label2.Text = "Nombres:";
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(68, 214);
            label3.Name = "label3";
            label3.Size = new Size(116, 20);
            label3.TabIndex = 8;
            label3.Text = "Primer Apellido:";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(373, 208);
            label4.Name = "label4";
            label4.Size = new Size(132, 20);
            label4.TabIndex = 9;
            label4.Text = "Segundo Apellido:";
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(203, 284);
            label5.Name = "label5";
            label5.Size = new Size(50, 20);
            label5.TabIndex = 10;
            label5.Text = "Titulo:";
            // 
            // lblinfo
            // 
            lblinfo.AutoSize = true;
            lblinfo.Location = new Point(373, 411);
            lblinfo.Name = "lblinfo";
            lblinfo.Size = new Size(0, 20);
            lblinfo.TabIndex = 11;
            
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(lblinfo);
            Controls.Add(label5);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(label1);
            Controls.Add(btnEmitirTitulo);
            Controls.Add(txtTitulo);
            Controls.Add(txtSegundoApellido);
            Controls.Add(txtPrimerApellido);
            Controls.Add(txtNombres);
            Controls.Add(txtCI);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private TextBox txtCI;
        private TextBox txtNombres;
        private TextBox txtPrimerApellido;
        private TextBox txtSegundoApellido;
        private TextBox txtTitulo;
        private Button btnEmitirTitulo;
        private Label label1;
        private Label label2;
        private Label label3;
        private Label label4;
        private Label label5;
        private Label lblinfo;
    }
}
