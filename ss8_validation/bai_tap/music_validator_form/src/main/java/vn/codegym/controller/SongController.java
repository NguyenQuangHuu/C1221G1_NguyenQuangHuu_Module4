package vn.codegym.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import vn.codegym.dto.SongDto;
import vn.codegym.model.Song;
import vn.codegym.service.ISongService;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
public class SongController {

    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ISongService songService;

    @GetMapping("/create")
    public String musicForm(Model model){
        model.addAttribute("songDto",new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String musicUploadSubmit(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult,
                                    @RequestParam MultipartFile file,
                                    Model model){
        new SongDto().validate(songDto,bindingResult);
        String filePath = file.getOriginalFilename();
        try {
            FileCopyUtils.copy(file.getBytes(),new File(fileUpload+filePath));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if(bindingResult.hasFieldErrors()){
            return "create";
        }else{
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            String uploadDate = localDate.format(dateTimeFormatter);
            songDto.setUploadDate(uploadDate);
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            song.setPathFile(filePath);
            this.songService.save(song);
            Song lastSong = this.songService.getLast();
            model.addAttribute("song",lastSong);
            return "result";
        }

    }


    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable int id, Model model){
        Song song = this.songService.findById(id);
        SongDto songDto = new SongDto();
        BeanUtils.copyProperties(song,songDto);
        model.addAttribute("songDto",songDto);
        return "edit";
    }

    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute @Validated SongDto songDto,BindingResult bindingResult){
        new SongDto().validate(songDto,bindingResult);

        if(bindingResult.hasFieldErrors()){
            return "edit";
        }else{
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            this.songService.save(song);
            return "redirect:/create";
        }

    }

}
