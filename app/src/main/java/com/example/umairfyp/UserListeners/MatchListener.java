package com.example.umairfyp.UserListeners;

import com.google.firebase.firestore.auth.User;

public interface MatchListener {

    void onMatchClicked(User user);
}
