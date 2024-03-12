
package usfx.lab3_ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    final Socket clientSocket;
    final DataInputStream dis;
    final DataOutputStream dos;
    final List<ClientHandler> clients;
    private List<String> taskList = new ArrayList<>();


    public ClientHandler(Socket socket, DataInputStream dis, DataOutputStream dos, List<ClientHandler> clients) {
        this.clientSocket = socket;
        this.dis = dis;
        this.dos = dos;
        this.clients = clients;
    }

    @Override
    public void run() {
        try {
            while (true) {
                dos.writeUTF("1. Agregar tarea\n2. Eliminar tarea\n3. Listar tareas\n4. Salir\nIngrese la opción:");
                String option = dis.readUTF();

                switch (option) {
                    case "1":
                        dos.writeUTF("Ingrese la tarea a agregar:");
                        String newTask = dis.readUTF();
                        addTask(newTask);
                        break;
                    case "2":
                        dos.writeUTF("Ingrese el índice de la tarea a eliminar:");
                        int indexToRemove = Integer.parseInt(dis.readUTF());
                        removeTask(indexToRemove);
                        break;
                    case "3":
                        dos.writeUTF("Lista de tareas:\n" + getTaskList());
                        break;
                    case "4":
                        // Salir del bucle si el cliente elige salir
                        clients.remove(this);
                        clientSocket.close();
                        ServerMultihilo.broadcastTaskLists();
                        return;
                    default:
                        dos.writeUTF("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void addTask(String task) {
        taskList.add(task);
        ServerMultihilo.broadcastTaskLists();
    }

    private synchronized void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            ServerMultihilo.broadcastTaskLists();
        }
    }

    synchronized String getTaskList() {
        StringBuilder tasks = new StringBuilder();
        for (int i = 0; i < taskList.size(); i++) {
            tasks.append(i).append(". ").append(taskList.get(i)).append("\n");
        }
        return tasks.toString();
    }

    void sendTaskList(String taskList) throws IOException {
        dos.writeUTF(taskList);
    }
}
