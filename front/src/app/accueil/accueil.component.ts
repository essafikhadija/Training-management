import { Component, OnInit } from '@angular/core';
import { IImage } from 'node_modules/ng-simple-slideshow/src/app/modules/slideshow/IImage';
@Component({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.css']
})
export class AccueilComponent implements OnInit {

  imageUrls: (string | IImage)[] = [
    { url: 'https://mptnoticias.com/inicio/wp-content/uploads/2019/05/cowomen-1550122-unsplash.jpg', caption: 'Welcome', href: '#config' },
    { url: 'https://collabocreative.com/wp-content/uploads/2019/05/cowomen-1504010-unsplash.jpg', caption: "Inscrivez-vous , tarifs raisonables & places limitées" ,clickAction: () => alert('redirection vers Inscription') },
    { url: 'https://perspectivasocial.co/wp-content/uploads/2018/05/agencia-redes-sociales-bogota-1.jpg', caption: 'Journée de formation GRATUIT !!', href: '#config' ,clickAction: () => alert('redirection vers Inscription')},
    { url: 'https://cdn.lynda.com/course/377484/377484-636807313660331603-16x9.jpg', caption: 'Formation accélérée en JAVA ', href: '#config' ,clickAction: () => alert('redirection vers Inscription')},
    { url: 'https://cdn-images-1.medium.com/max/2600/1*FDIQCYA3BNp9Ek-tqGeQjA.png', caption: 'Formation débutant en ANGULAR ', href: '#config' ,clickAction: () => alert('redirection vers Inscription')},
    { url: 'https://d33wubrfki0l68.cloudfront.net/33282cd91fc50462bc515a615cccafa37fe07a63/3e476/images/logo.png', caption: 'Formation technique en Docker ', href: '#config' ,clickAction: () => alert('redirection vers Inscription')},

     ];

  height: string = '600px';
  minHeight: string;
  arrowSize: string = '30px';
  showArrows: boolean = true;
  disableSwiping: boolean = false;
  autoPlay: boolean = true;
  autoPlayInterval: number = 3333;
  stopAutoPlayOnSlide: boolean = true;
  debug: boolean = false;
  backgroundSize: string = 'cover';
  backgroundPosition: string = 'center center';
  backgroundRepeat: string = 'no-repeat';
  showDots: boolean = true;
  dotColor: string = '#FFF';
  showCaptions: boolean = true;
  captionColor: string = '#FFF';
  captionBackground: string = 'rgba(0, 0, 0, .35)';
  lazyLoad: boolean = false;
  hideOnNoSlides: boolean = false;
  width: string = '100%';
  fullscreen: boolean = false;

  ngOnInit() {

  }
}
