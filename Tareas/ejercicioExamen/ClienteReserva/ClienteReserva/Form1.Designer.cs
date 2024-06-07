namespace ClienteReserva
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
            dateinicio = new DateTimePicker();
            label2 = new Label();
            label3 = new Label();
            label4 = new Label();
            datefin = new DateTimePicker();
            comboBox1 = new ComboBox();
            label5 = new Label();
            btnverificar = new Button();
            respuesta = new TextBox();
            SuspendLayout();
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Font = new Font("Segoe UI", 12F, FontStyle.Bold, GraphicsUnit.Point, 0);
            label1.Location = new Point(132, 28);
            label1.Name = "label1";
            label1.Size = new Size(155, 21);
            label1.TabIndex = 1;
            label1.Text = "RESERVAR CLIENTE";
            label1.Click += label1_Click;
            // 
            // dateinicio
            // 
            dateinicio.Location = new Point(116, 85);
            dateinicio.Name = "dateinicio";
            dateinicio.Size = new Size(241, 26);
            dateinicio.TabIndex = 3;
            dateinicio.ValueChanged += dateTimePicker1_ValueChanged;
            // 
            // label2
            // 
            label2.AutoSize = true;
            label2.Location = new Point(45, 66);
            label2.Name = "label2";
            label2.Size = new Size(0, 19);
            label2.TabIndex = 4;
            // 
            // label3
            // 
            label3.AutoSize = true;
            label3.Location = new Point(35, 85);
            label3.Name = "label3";
            label3.Size = new Size(47, 19);
            label3.TabIndex = 5;
            label3.Text = "Desde";
            // 
            // label4
            // 
            label4.AutoSize = true;
            label4.Location = new Point(35, 138);
            label4.Name = "label4";
            label4.Size = new Size(44, 19);
            label4.TabIndex = 6;
            label4.Text = "Hasta";
            // 
            // datefin
            // 
            datefin.Location = new Point(116, 131);
            datefin.Name = "datefin";
            datefin.Size = new Size(241, 26);
            datefin.TabIndex = 7;
            datefin.ValueChanged += datefin_ValueChanged;
            // 
            // comboBox1
            // 
            comboBox1.FormattingEnabled = true;
            comboBox1.Items.AddRange(new object[] { "cotizar", "reservar" });
            comboBox1.Location = new Point(150, 188);
            comboBox1.Name = "comboBox1";
            comboBox1.Size = new Size(171, 27);
            comboBox1.TabIndex = 9;
            comboBox1.SelectedIndexChanged += comboBox1_SelectedIndexChanged;
            // 
            // label5
            // 
            label5.AutoSize = true;
            label5.Location = new Point(34, 191);
            label5.Name = "label5";
            label5.Size = new Size(85, 19);
            label5.TabIndex = 10;
            label5.Text = "Operaciones";
            // 
            // btnverificar
            // 
            btnverificar.Location = new Point(44, 236);
            btnverificar.Name = "btnverificar";
            btnverificar.Size = new Size(75, 23);
            btnverificar.TabIndex = 11;
            btnverificar.Text = "Verificar";
            btnverificar.UseVisualStyleBackColor = true;
            btnverificar.Click += btnverificar_Click;
            // 
            // respuesta
            // 
            respuesta.Location = new Point(45, 290);
            respuesta.Multiline = true;
            respuesta.Name = "respuesta";
            respuesta.Size = new Size(312, 58);
            respuesta.TabIndex = 12;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 19F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(417, 414);
            Controls.Add(respuesta);
            Controls.Add(btnverificar);
            Controls.Add(label5);
            Controls.Add(comboBox1);
            Controls.Add(datefin);
            Controls.Add(label4);
            Controls.Add(label3);
            Controls.Add(label2);
            Controls.Add(dateinicio);
            Controls.Add(label1);
            Name = "Form1";
            Text = "Form1";
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion
        private Label label1;
        private DateTimePicker dateinicio;
        private Label label2;
        private Label label3;
        private Label label4;
        private DateTimePicker datefin;
        private ComboBox comboBox1;
        private Label label5;
        private Button btnverificar;
        private TextBox respuesta;
    }
}
