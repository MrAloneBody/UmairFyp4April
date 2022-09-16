package com.example.umairfyp.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.ServerTimestamp

data class Comment(
    @DocumentId
    var id: String = "",
    var email: String = "",
    var message: String = "",
    var name: String = "",
    var match_id: String = "",
    var user_id: String = "",
    var timestamp: Timestamp = Timestamp.now()
)