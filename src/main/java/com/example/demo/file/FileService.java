package com.example.demo.file;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

@Service
public class FileService {
    private final FileRepository fileRepository;
    
    @Autowired
    private HttpServletRequest request;

    @Autowired
    public FileService(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public File saveFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        String filePath = request.getServletContext().getRealPath("/");
        File file_local = new File(fileName, file.getBytes());
        String fileDate = fileName.substring(0, fileName.indexOf('.'));
        file_local.setFileDate(formatDate(fileDate));
        file_local.setFilePath(filePath);
        return fileRepository.save(file_local);
    }

    public String getInfo(String fileName) {
        List<File> list = fileRepository.findAll();
        List<File> answerList = new ArrayList<File>();
        Integer id = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFileName().equals(fileName)) {
                System.out.println(list.get(i));
                id = list.get(i).getId();
                answerList.add(fileRepository.findById(id).get());
            }
        }
        return prettify(answerList);
    }

    public String prettify(List<File> list) {
        String answer = "";
        for (int i = 0; i < list.size(); i++) {
            answer = answer + "fileName='" + list.get(i).getFileName() + "'" +
                    ", fileDate='" + list.get(i).getFileDate().getDayOfMonth() + " " +
                    list.get(i).getFileDate().getMonth() + ", " +
                    list.get(i).getFileDate().getYear() + " at " +
                    list.get(i).getFileDate().getHour() + ":" +
                    getMin(list.get(i).getFileDate()) + "'" +
                    ", filePath='" + list.get(i).getFilePath() + "'" +
                    "," + "\n";
        }
        return answer;
    }
    
    public String getMin(LocalDateTime date) {
        String answer = "";
        if (date.getMinute() < 10) {
            answer = answer + "0" + date.getMinute();
        } else {
            answer = answer + date.getMinute();
        }
        return answer;
    }

    private LocalDateTime formatDate(String fileName) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
        LocalDateTime date = LocalDateTime.parse(fileName, formatter);
        return date;
    }
}
