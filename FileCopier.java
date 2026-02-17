package my_tool;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileCopier {
    public static void main(String[] args) {
        // 创建文件选择对话框
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("選擇檔案");
        
        int result = fileChooser.showOpenDialog(null);
        if (result != JFileChooser.APPROVE_OPTION) {
            System.exit(0);
        }
        
        // 获取选择的文件路径
        Path sourceFile = fileChooser.getSelectedFile().toPath();
        System.out.println("您選擇的檔案完整路徑：" + sourceFile.toAbsolutePath());
        
        // 通过注册表获取桌面路径
        Path desktopPath = getDesktopPathFromRegistry();
        if (desktopPath == null) {
            System.err.println("無法從註冊表獲取桌面路徑");
            return;
        }
        
        // 设置目标文件路径
        Path destinationFile = desktopPath.resolve("fyi.txt");
        
        try {
            // 复制文件（覆盖已存在的文件）
            Files.copy(sourceFile, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("檔案已複製至桌面：" + destinationFile);
        } catch (IOException e) {
            System.err.println("複製失敗：" + e.getMessage());
        }
    }
    
    private static Path getDesktopPathFromRegistry() {
        try {
            // 执行注册表查询命令
            Process process = Runtime.getRuntime().exec(
                "reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\User Shell Folders\" /v Desktop"
            );
            
            // 读取命令输出
//            Scanner scanner = new Scanner(process.getInputStream(), "UTF-8");
            Scanner scanner = new Scanner(process.getInputStream(), "MS950");
            StringBuilder output = new StringBuilder();
            while (scanner.hasNextLine()) {
                output.append(scanner.nextLine()).append("\n");
            }
            
            // 等待命令执行完成
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                return null;
            }
            
            // 使用正则表达式提取路径
            Pattern pattern = Pattern.compile("REG_EXPAND_SZ\\s+(.*)");
            Matcher matcher = pattern.matcher(output.toString());
            if (matcher.find()) {
                String rawPath = matcher.group(1).trim();
                
                // 处理环境变量（如%USERPROFILE%）
                if (rawPath.contains("%")) {
                    for (String part : rawPath.split("%")) {
                        if (!part.isEmpty()) {
                            String envValue = System.getenv(part);
                            if (envValue != null) {
                                rawPath = rawPath.replace("%" + part + "%", envValue);
                            }
                        }
                    }
                }
                return Paths.get(rawPath);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("註冊表讀取錯誤: " + e.getMessage());
        }
        return null;
    }
}
