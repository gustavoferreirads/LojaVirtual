package br.com.lojavirtual.api.modelo;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: JoãoGustavo
 * Date: 12/02/15
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
public class File {
    private List<MultipartFile> files;


    public List<MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
}
