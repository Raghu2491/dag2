package com.example.raghu_gowda.dag2.api_dag;

import com.example.raghu_gowda.dag2.ui.MainActivity;

import dagger.Component;

@NewScope
@Component(modules = RetroProvider.class,dependencies = ApiModuleComponent.class)
public interface RetroProviderComponent {
    void inject(MainActivity mainActivity);

}
