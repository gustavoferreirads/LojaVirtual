package br.com.lojavirtual.api.modelo;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 * User: JoãoGustavo
 * Date: 12/02/15
 * Time: 08:58
 * To change this template use File | Settings | File Templates.
 */
public class File {
    private MultipartFile[] file;

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

}
