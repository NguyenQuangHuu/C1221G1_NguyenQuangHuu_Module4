package vn.codegym.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.codegym.service.SongService;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private SongService songService;

    @GetMapping("/music")
    public String musicHomepage(Model model){
        model.addAttribute("musics",this.songService.getAllSong());
        return "/index";
    }

    @GetMapping("/create-song")
    public String addSongForm(Model model){
        model.addAttribute("song",new Song());
        return "/create";
    }

    @PostMapping("/create-song")
    public String addSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes){
        this.songService.newSong(song);
        redirectAttributes.addFlashAttribute("message","tạo mới thành công");
        return "redirect:/music";
    }
}
