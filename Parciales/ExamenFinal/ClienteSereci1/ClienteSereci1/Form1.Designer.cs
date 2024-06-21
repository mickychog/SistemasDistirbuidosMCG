namespace ClienteSereci
{
    partial class Form1
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
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
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            txtCI = new TextBox();
            btnObtenerDatos = new Button();
            btnObtenerCertificado = new Button();
            dataGridView = new DataGridView();
            label1 = new Label();
            ((System.ComponentModel.ISupportInitialize)dataGridView).BeginInit();
            SuspendLayout();
            // 
            // txtCI
            // 
            txtCI.Location = new Point(153, 40);
            txtCI.Margin = new Padding(4, 5, 4, 5);
            txtCI.Name = "txtCI";
            txtCI.Size = new Size(345, 27);
            txtCI.TabIndex = 0;
            txtCI.Text = "Ingrese Ci";
            txtCI.TextChanged += txtCI_TextChanged;
            // 
            // btnObtenerDatos
            // 
            btnObtenerDatos.Location = new Point(153, 80);
            btnObtenerDatos.Margin = new Padding(4, 5, 4, 5);
            btnObtenerDatos.Name = "btnObtenerDatos";
            btnObtenerDatos.Size = new Size(160, 35);
            btnObtenerDatos.TabIndex = 1;
            btnObtenerDatos.Text = "Obtener Datos";
            btnObtenerDatos.UseVisualStyleBackColor = true;
            btnObtenerDatos.Click += btnObtenerDatos_Click;
            // 
            // btnObtenerCertificado
            // 
            btnObtenerCertificado.Location = new Point(340, 80);
            btnObtenerCertificado.Margin = new Padding(4, 5, 4, 5);
            btnObtenerCertificado.Name = "btnObtenerCertificado";
            btnObtenerCertificado.Size = new Size(160, 35);
            btnObtenerCertificado.TabIndex = 2;
            btnObtenerCertificado.Text = "Obtener Certificado";
            btnObtenerCertificado.UseVisualStyleBackColor = true;
            btnObtenerCertificado.Click += btnObtenerCertificado_Click;
            // 
            // dataGridView
            // 
            dataGridView.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridView.Location = new Point(121, 125);
            dataGridView.Margin = new Padding(4, 5, 4, 5);
            dataGridView.Name = "dataGridView";
            dataGridView.RowHeadersWidth = 51;
            dataGridView.Size = new Size(426, 280);
            dataGridView.TabIndex = 3;
            // 
            // label1
            // 
            label1.AutoSize = true;
            label1.Location = new Point(297, 9);
            label1.Name = "label1";
            label1.Size = new Size(80, 20);
            label1.TabIndex = 4;
            label1.Text = "Pregunta 4";
            label1.Click += label1_Click;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(723, 447);
            Controls.Add(label1);
            Controls.Add(dataGridView);
            Controls.Add(btnObtenerCertificado);
            Controls.Add(btnObtenerDatos);
            Controls.Add(txtCI);
            Margin = new Padding(4, 5, 4, 5);
            Name = "Form1";
            Text = "Cliente Sereci";
            ((System.ComponentModel.ISupportInitialize)dataGridView).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private System.Windows.Forms.TextBox txtCI;
        private System.Windows.Forms.Button btnObtenerDatos;
        private System.Windows.Forms.Button btnObtenerCertificado;
        private System.Windows.Forms.DataGridView dataGridView;
        private Label label1;
    }
}
