import { Component } from '@angular/core';
import { PostService } from './services/post.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
	posts:any;
	constructor(private service:PostService){}
	ngOnInit(){
		this.service.getPosts()
		.subsribe(response=>{
			this.posts=response;
		});
	}
  title = 'test_app';
}
