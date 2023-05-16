package com.example.mycustomviewsarchiterure.content.presentation

import com.example.mycustomviewsarchiterure.core.Communication

interface ContentCommunication : Communication.Mutable<ContentUiState> {
class Base() : Communication.Abstract<ContentUiState>(), ContentCommunication
}
