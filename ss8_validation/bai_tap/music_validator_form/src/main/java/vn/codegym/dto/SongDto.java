package vn.codegym.dto;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

public class SongDto implements Validator {
    private int id;
    private String name;
    private String singer;
    private String kindOfMusic;


    private String uploadDate;

//    @Value("\\resources\\static\\")
//    private MultipartFile filePath;

    public SongDto() {
    }

    public SongDto(String name, String singer, String kindOfMusic, String uploadDate) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.uploadDate = uploadDate;
    }

//    public SongDto(String name, String singer, String kindOfMusic, String uploadDate, MultipartFile filePath) {
//        this.name = name;
//        this.singer = singer;
//        this.kindOfMusic = kindOfMusic;
//        this.uploadDate = uploadDate;
//        this.filePath = filePath;
//    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }

//    public MultipartFile getFilePath() {
//        return filePath;
//    }
//
//    public void setFilePath(MultipartFile filePath) {
//        this.filePath = filePath;
//    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if("".equals(songDto.getName())){
            errors.rejectValue("name","name.notNull","Nonnn");
        }else if(!songDto.getName().matches("^(\\s?[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]\\s?)*$")){
            errors.rejectValue("name","name.specialCharacter","Non");
        }else if(songDto.getName().length()>800){
            errors.rejectValue("name","name.length","non");
        }

        if("".equals(songDto.getSinger())){
            errors.rejectValue("singer","singer.notNull","Nonnn");
        }else if(!songDto.getSinger().matches("^(\\s?[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ0-9]\\s?)*$")){
            errors.rejectValue("singer","singer.specialCharacter","Non");
        }else if(songDto.getSinger().length()>300){
            errors.rejectValue("singer","singer.length","Nonn");
        }

        if("".equals(songDto.getKindOfMusic())){
            errors.rejectValue("kindOfMusic","kindOfMusic.notNull","Nonnn");
        }else if(!songDto.getKindOfMusic().matches("^(\\s?[a-zA-Z_0-9ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]\\s?)*$")){
            errors.rejectValue("kindOfMusic","kindOfMusic.specialCharacter","Non");
        }else if(songDto.getKindOfMusic().length()>1000){
            errors.rejectValue("kindOfMusic","kindOfMusic.length","Nonn");
        }
    }
}
