package com.example.mycustomviewsarchiterure.content.category.presentation

import com.example.mycustomviewsarchiterure.core.Communication

interface CategoriesCommunication : Communication.Mutable<CategoriesUiState> {
    class Base : Communication.Abstract<CategoriesUiState>(), CategoriesCommunication
}