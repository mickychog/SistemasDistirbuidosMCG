namespace Lab_5_ConsumirServicio
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
            label1 = new Label();
            label2 = new Label();
            txtci = new TextBox();
            label3 = new Label();
            cmbboxop = new ComboBox();
            resp = new Label();
            btnGenerar = new Button();
            label4 = new Label();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 14.25F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(58, 9);
            label1.Name = "label1";
            label1.Size = new Size(208, 25);
            label1.TabIndex = 0;
            label1.Text = "SERVICIO WEB SERECI";
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(31, 91);
            label2.Name = "label2";
            label2.Size = new Size(89, 19);
            label2.TabIndex = 1;
            label2.Text = "Introducir CI:";
            // 
            // txtci
            // 
            txtci.Location = new Point(155, 91);
            txtci.Name = "txtci";
            txtci.Size = new Size(100, 26);
            txtci.TabIndex = 2;
            txtci.TextChanged += txtci_TextChanged;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(34, 148);
            label3.Name = "label3";
            label3.Size = new Size(72, 19);
            label3.TabIndex = 3;
            label3.Text = "Operacion";
            // 
            // cmbboxop
            // 
            cmbboxop.FormattingEnabled = true;
            cmbboxop.Items.AddRange(new object[] { "obt datos", "obt cert nacim", "obt cert matrim", "obt cert defun" });
            cmbboxop.Location = new Point(145, 148);
            cmbboxop.Name = "cmbboxop";
            cmbboxop.Size = new Size(121, 27);
            cmbboxop.TabIndex = 4;
            // 
            // resp
            // 
            resp.AutoSize = true;
            resp.Location = new Point(145, 205);
            resp.Name = "resp";
            resp.Size = new Size(71, 19);
            resp.TabIndex = 5;
            resp.Text = "Respuesta";
            // 
            // btnGenerar
            // 
            btnGenerar.Location = new Point(31, 198);
            btnGenerar.Name = "btnGenerar";
            btnGenerar.Size = new Size(75, 33);
            btnGenerar.TabIndex = 6;
            btnGenerar.Text = "Generar";
            btnGenerar.UseVisualStyleBackColor = true;
            btnGenerar.Click += button1_Click;
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(34, 46);
            label4.Name = "label4";
            label4.Size = new Size(244, 19);
            label4.TabIndex = 7;
            label4.Text = "CESAR ALVARO MIRANDA GUTIERREZ";
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 19F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(316, 339);
            Controls.Add(label4);
            Controls.Add(btnGenerar);
            Controls.Add(resp);
            Controls.Add(cmbboxop);
            Controls.Add(label3);
            Controls.Add(txtci);
            Controls.Add(label2);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label label1;
        private Label label2;
        private TextBox txtci;
        private Label label3;
        private ComboBox cmbboxop;
        private Label resp;
        private Button btnGenerar;
        private Label label4;
    }
}
