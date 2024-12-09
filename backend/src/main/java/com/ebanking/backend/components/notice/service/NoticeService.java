package com.ebanking.backend.components.notice.service;

import com.ebanking.backend.EntityComponentsProvider.service.EntityServiceImpl;
import com.ebanking.backend.components.notice.dto.request.CreateNoticeDTO;
import com.ebanking.backend.components.notice.dto.request.UpdateNoticeDTO;
import com.ebanking.backend.components.notice.dto.response.NoticeResponseDTO;
import com.ebanking.backend.components.notice.mapper.NoticeMapper;
import com.ebanking.backend.components.notice.repository.NoticeRepository;
import com.ebanking.backend.entities.Notice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class NoticeService extends EntityServiceImpl<Notice, Long, CreateNoticeDTO, UpdateNoticeDTO, NoticeResponseDTO> {
    private final NoticeRepository noticeRepository;
    private final NoticeMapper noticeMapper;

    public NoticeService(
            NoticeRepository noticeRepository,
            NoticeMapper noticeMapper,
            ApplicationContext applicationContext) {
        super(noticeRepository, noticeMapper, applicationContext);
        this.noticeRepository = noticeRepository;
        this.noticeMapper = noticeMapper;
    }
}
