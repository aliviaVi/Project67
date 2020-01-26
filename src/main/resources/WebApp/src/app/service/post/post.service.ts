import { Injectable } from '@angular/core';
import { PostDto } from '../../dto/PostDto';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {PageDto} from '../../dto/PageDto';


@Injectable({
  providedIn: 'root'
})
export class PostService {

  private URL_POST = '/api/post';
  private URL_POST_PAGE = '/api/post/pages';

  constructor(private http: HttpClient) { }

  getPost(id: number): Observable<PostDto> {
    return this.http.get<PostDto>(this.URL_POST + `/${id}`);
  }

  getAllPosts(): Observable<PostDto[]> {
    return this.http.get<PostDto[]>(this.URL_POST);
  }

  savePost(postDto: PostDto) {
    return this.http.post(this.URL_POST, postDto);
  }

  getAllPostsPages(page: number, size: number): Observable<PageDto> {
    return this.http.get<PageDto>(this.URL_POST_PAGE + '?page=' + page + '&size=' + size);
  }
}
