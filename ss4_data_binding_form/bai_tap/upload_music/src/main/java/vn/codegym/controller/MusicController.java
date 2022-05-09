package vn.codegym.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.codegym.model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import vn.codegym.service.SongService;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private SongService songService;

    @GetMapping("/music")
    public String musicHomepage(Model model) {
        model.addAttribute("musics", this.songService.getAllSong());
        return "/index";
    }

    @GetMapping("/create-song")
    public String addSongForm(Model model) {
        model.addAttribute("song", new Song());
        return "/create";
    }

    @PostMapping("/create-song")
    public String addSong(@ModelAttribute Song song, RedirectAttributes redirectAttributes) {
        this.songService.newSong(song);
        redirectAttributes.addFlashAttribute("message", "Tạo mới thành công");
        return "redirect:/music";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Integer id, Model model) {
        Song song = this.songService.findOne(id);
        model.addAttribute("song", song);
        return "/edit";
    }

    @PostMapping("/edit")
    public String editSubmit(@ModelAttribute("song") Song song, Model model,RedirectAttributes redirectAttributes) {
        this.songService.editSong(song);
        redirectAttributes.addFlashAttribute("message","Chỉnh sửa thành công");
        return "redirect:/music";
    }

    @GetMapping("/delete/")
    public String deleteOne(@RequestParam Integer id, RedirectAttributes redirectAttributes){
        Song song = this.songService.findOne(id);
        if(song == null){
            return "/error";
        }
        this.songService.deleteOne(song);
        redirectAttributes.addFlashAttribute("message","xóa thành công");
        return "redirect:/music";
    }


    @GetMapping("/listen/{id}")
    public String listenMusic(@PathVariable Integer id,Model model){
        Song song = this.songService.findOne(id);
        model.addAttribute("song",song);
        return "/listen";
    }

}
