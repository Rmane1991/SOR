package SOR_resources;

import java.io.*;

public class LocalLLMExample {
    public static void main(String[] args) {
        try {
            System.out.println("Starting Java program...");

            // Full path to Ollama
            String ollamaPath = "C:\\Users\\rajendra.mane\\AppData\\Local\\Programs\\Ollama\\ollama.exe";
            System.out.println("Using Ollama path: " + ollamaPath);

            // Create ProcessBuilder
            ProcessBuilder builder = new ProcessBuilder(
                ollamaPath, "run", "mistral"
            );

            builder.redirectErrorStream(true);
            Process process = builder.start();
            System.out.println("Ollama process started...");

            // Send input to Ollama
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));
            writer.write("Hello, how are you?\n");
            writer.flush();
            writer.close();
            System.out.println("Sent input to Ollama...");

            // Read Ollama response
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("LLM Response: " + line);
            }

            // Wait for process to finish
            int exitCode = process.waitFor();
            System.out.println("Process exited with code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            System.out.println("Error: Could not start Ollama. Please check the path and installation.");
        }
    }
}
