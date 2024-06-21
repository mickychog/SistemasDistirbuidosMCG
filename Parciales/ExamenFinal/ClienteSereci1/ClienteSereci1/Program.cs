using ClienteSereci;

namespace ClienteSereci1
{
    internal static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            // Crear una instancia de Form1 y mostrarla
            Application.Run(new Form1());
        }
    }
}