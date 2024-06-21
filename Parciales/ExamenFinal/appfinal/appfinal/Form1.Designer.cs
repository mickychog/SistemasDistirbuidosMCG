namespace appfinal
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
            lblTitle = new Label();
            cmbServiceType = new ComboBox();
            btnFetchData = new Button();
            dataGridViewResults = new DataGridView();
            ((System.ComponentModel.ISupportInitialize)dataGridViewResults).BeginInit();
            SuspendLayout();
            // 
            // lblTitle
            // 
            lblTitle.AutoSize = true;
            lblTitle.Location = new Point(337, 46);
            lblTitle.Name = "lblTitle";
            lblTitle.Size = new Size(111, 20);
            lblTitle.TabIndex = 0;
            lblTitle.Text = "EXAMEN FINAL";
            lblTitle.Click += lblTitle_Click;
            // 
            // cmbServiceType
            // 
            cmbServiceType.FormattingEnabled = true;
            cmbServiceType.Items.AddRange(new object[] { "REST", "GRAPHQL" });
            cmbServiceType.Location = new Point(187, 166);
            cmbServiceType.Name = "cmbServiceType";
            cmbServiceType.Size = new Size(151, 28);
            cmbServiceType.TabIndex = 1;
            cmbServiceType.Text = "Seleccionar";
            // 
            // btnFetchData
            // 
            btnFetchData.Location = new Point(381, 166);
            btnFetchData.Name = "btnFetchData";
            btnFetchData.Size = new Size(94, 29);
            btnFetchData.TabIndex = 2;
            btnFetchData.Text = "Enviar";
            btnFetchData.UseVisualStyleBackColor = true;
            btnFetchData.Click += button1_Click;
            // 
            // dataGridViewResults
            // 
            dataGridViewResults.ColumnHeadersHeightSizeMode = DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            dataGridViewResults.Location = new Point(143, 271);
            dataGridViewResults.Name = "dataGridViewResults";
            dataGridViewResults.RowHeadersWidth = 51;
            dataGridViewResults.Size = new Size(491, 167);
            dataGridViewResults.TabIndex = 3;
            // 
            // Form1
            // 
            AutoScaleDimensions = new SizeF(8F, 20F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(800, 450);
            Controls.Add(dataGridViewResults);
            Controls.Add(btnFetchData);
            Controls.Add(cmbServiceType);
            Controls.Add(lblTitle);
            Name = "Form1";
            Text = "Form1";
            ((System.ComponentModel.ISupportInitialize)dataGridViewResults).EndInit();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private Label lblTitle;
        private ComboBox cmbServiceType;
        private Button btnFetchData;
        private DataGridView dataGridViewResults;
    }

}
