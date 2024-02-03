import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {FormsModule} from "@angular/forms";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {FlexLayoutModule, FlexModule} from "@angular/flex-layout";
import {FlexLayoutServerModule} from "@angular/flex-layout/server";


const modules = [
  FormsModule,
  MatSlideToggleModule, FlexModule, FlexLayoutModule
]


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ...modules
  ],
  exports: [
    ...modules
  ]
})
export class SharedModule {
}
