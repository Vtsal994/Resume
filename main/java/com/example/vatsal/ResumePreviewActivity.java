package com.example.vatsal;


import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.vatsal.model.Resume;

public class ResumePreviewActivity extends AppCompatActivity {

    TextView nameText, emailText, linkedInText, skillsText, educationText;
    ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_preview);

        // Initialize UI components
        profileImageView = findViewById(R.id.imageViewPreviewProfile);
        nameText = findViewById(R.id.textViewName);
        emailText = findViewById(R.id.textViewEmail);
        linkedInText = findViewById(R.id.textViewLinkedIn);
        skillsText = findViewById(R.id.textViewSkills);
        educationText = findViewById(R.id.textViewEducation);

        // Get resume object and image URI from intent
        Resume resume = (Resume) getIntent().getSerializableExtra("resume");
        String imageUriStr = getIntent().getStringExtra("imageUri");

        // Set data to UI
        if (resume != null) {
            nameText.setText("Name: " + resume.getName());
            emailText.setText("Email: " + resume.getEmail());
            linkedInText.setText("LinkedIn: " + resume.getLinkedIn());
            skillsText.setText("Skills: " + resume.getSkills());
            educationText.setText("Education: " + resume.getEducation());
        }

        // Set selected image if available
        if (imageUriStr != null) {
            Uri imageUri = Uri.parse(imageUriStr);
            profileImageView.setImageURI(imageUri);
        }
    }
}
