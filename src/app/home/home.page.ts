import Unity from '../unity.plugin';
import { Component } from '@angular/core';
import { IonHeader, IonToolbar, IonTitle, IonContent, IonButton } from '@ionic/angular/standalone';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  imports: [IonHeader, IonToolbar, IonTitle, IonContent, IonButton],
})
export class HomePage {
  constructor() {}

  async onLaunchUnity(): Promise<void> {
    try {
      await Unity.launch();
    } catch (err) {
      console.error('Failed to launch Unity:', err);
    }
  }
}
