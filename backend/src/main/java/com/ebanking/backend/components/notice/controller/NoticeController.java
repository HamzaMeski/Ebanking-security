package com.ebanking.backend.components.notice.controller;

import com.ebanking.backend.EntityComponentsProvider.controller.Controller;
import com.ebanking.backend.components.notice.dto.request.CreateNoticeDTO;
import com.ebanking.backend.components.notice.dto.request.UpdateNoticeDTO;
import com.ebanking.backend.components.notice.dto.response.NoticeResponseDTO;
import com.ebanking.backend.components.notice.service.NoticeService;
import com.ebanking.backend.entities.Notice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/notices")
public class NoticeController extends Controller<Notice, Long, CreateNoticeDTO, UpdateNoticeDTO, NoticeResponseDTO> {
    private final NoticeService noticeService;

    public NoticeController(NoticeService noticeService) {
        super(noticeService);
        this.noticeService = noticeService;
    }
}
