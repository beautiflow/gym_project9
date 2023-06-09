package com.example.p123.controller;

import com.example.p123.dto.NoticeSaveRequestDto;
import com.example.p123.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping("/notice")
    public String noticeList(Model model,
                             @PageableDefault(size = 10) Pageable pageable) {
        model.addAttribute("noticeList", noticeService.findAllDesc(pageable));
        return "/notice/noticeList";
    }
    @GetMapping("/admin/notice/save")
    public String noticeSave(Model model) {
        model.addAttribute("saveForm", new NoticeSaveRequestDto());
        return "notice/saveForm";
    }

    @GetMapping("/notice/{id}")
    public String notice(@PathVariable Long id, Model model) {
        model.addAttribute("notice", noticeService.findById(id));
        return "notice/detail";
    }

    @GetMapping("/admin/notice/update/{id}")
    public String noticeUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("notice", noticeService.findById(id));
        return "notice/update";
    }
}
