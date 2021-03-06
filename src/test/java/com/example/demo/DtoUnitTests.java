package com.example.demo;

import com.example.demo.controllers.dtos.AlbumDto;
import com.example.demo.controllers.dtos.ArtistDto;
import com.example.demo.controllers.dtos.TrackDto;
import com.example.demo.mappers.AlbumMapper;
import com.example.demo.mappers.ArtistMapper;
import com.example.demo.mappers.TrackMapper;
import com.example.demo.repositories.entities.AlbumEntity;
import com.example.demo.repositories.entities.ArtistEntity;
import com.example.demo.repositories.entities.TrackEntity;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class DtoUnitTests {

    @Test
    public void shouldConvertArtistEntityToDto() {
        ArtistEntity artistEntity = new ArtistEntity("artist");
        artistEntity.setId(1L);

        ArtistDto artistDto = ArtistMapper.artistEntityToArtistDto(artistEntity);
        assertThat(artistDto, is(notNullValue()));
        assertThat(artistDto.getName(), is(artistEntity.getName()));
        assertThat(artistDto.getId(), is(artistEntity.getId()));
    }

    @Test
    public void shouldConvertAlbumEntityToDto() {
        ArtistEntity artist = new ArtistEntity("artist");
        artist.setId(2L);
        AlbumEntity albumEntity = new AlbumEntity("album", artist);
        albumEntity.setId(3L);

        AlbumDto albumDto = AlbumMapper.albumEntityToAlbumDto(albumEntity);
        assertThat(albumDto, is(notNullValue()));
        assertThat(albumDto.getName(), is(albumEntity.getName()));
        assertThat(albumDto.getId(), is(albumEntity.getId()));
        assertThat(albumDto.getArtistName(), is(albumEntity.getArtist().getName()));
        assertThat(albumDto.getArtistId(), is(albumEntity.getArtist().getId()));
    }

    @Test
    public void shouldConvertAlbumDtoToEntity() {
        AlbumDto albumDto = new AlbumDto();
        albumDto.setName("album");
        albumDto.setId(1L);

        AlbumEntity albumEntity = AlbumMapper.albumDtoToAlbumEntity(albumDto);
        assertThat(albumEntity, is(notNullValue()));
        assertThat(albumDto.getName(), is(albumEntity.getName()));
        assertThat(albumDto.getId(), is(albumEntity.getId()));
    }

    @Test
    public void shouldConvertTrackEntityToDto() {
        ArtistEntity artist = new ArtistEntity("artist");
        artist.setId(1L);
        AlbumEntity album = new AlbumEntity("album", artist);
        album.setId(2L);
        TrackEntity trackEntity = new TrackEntity("track", album, 3);
        trackEntity.setId(3L);

        TrackDto trackDto = TrackMapper.trackEntityToTrackDto(trackEntity);
        assertThat(trackDto.getName(), is(trackEntity.getName()));
        assertThat(trackDto.getId(), is(trackEntity.getId()));
        assertThat(trackDto.getDuration(), is(trackEntity.getDuration()));
    }

    @Test
    public void shouldConvertTrackDtoToEntity() {
        TrackDto trackDto = new TrackDto();
        trackDto.setName("track");
        trackDto.setId(1L);
        trackDto.setDuration(3);

        TrackEntity trackEntity = TrackMapper.trackDtoToTrackEntity(trackDto);
        assertThat(trackDto.getName(), is(trackEntity.getName()));
        assertThat(trackDto.getId(), is(trackEntity.getId()));
        assertThat(trackDto.getDuration(), is(trackEntity.getDuration()));
    }
}
