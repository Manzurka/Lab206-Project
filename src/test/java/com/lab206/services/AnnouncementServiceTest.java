package com.lab206.services;

import com.lab206.models.Announcement;
import com.lab206.repositories.AnnouncementRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class AnnouncementServiceTest {

    private static final Object Announcement = null;

	@Mock
    private AnnouncementRepository repository;

    private AnnouncementService service;

    private Long announcementId;

    @Before
    public void setUp() {
        service = new AnnouncementService(repository);

        announcementId = 1L;
    }

    @Test
    public void GIVEN_data_WHEN_findAll_THEN_return_items() {
        List<Announcement> announcements = new ArrayList<>();
        announcements.add(new Announcement());
        announcements.add(new Announcement());
        announcements.add(new Announcement());

        Mockito.when(repository.findByOrderByIdDesc()).thenReturn(announcements);

        List<Announcement> result = service.findAll();

        Assert.assertEquals(3, result.size());
    }

    @Test
    public void testFindAllEmpty() {
        List<Announcement> announcements = new ArrayList<>();

        Mockito.when(repository.findByOrderByIdDesc()).thenReturn(announcements);

        List<Announcement> result = service.findAll();

        Assert.assertEquals(0, result.size());
    }

    @Test(expected = RuntimeException.class)
    public void testFindAllException() {
        Mockito.when(repository.findByOrderByIdDesc()).thenThrow(RuntimeException.class);
    }

    @Test
    public void testFindByIdSuccessful() {
        Optional<Announcement> optional = Optional.of(new Announcement());
        Mockito.when(repository.findById(announcementId)).thenReturn(optional);
        Announcement announcement = service.findById(announcementId);
        Assert.assertNotNull(announcement);
    }

    @Test
    public void testFindByIdEmpty() {
        Optional<Announcement> optional = Optional.empty();
        Mockito.when(repository.findById(announcementId)).thenReturn(optional);
		Assert.assertNull(Announcement);
    }


}
