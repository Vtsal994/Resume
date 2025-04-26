package com.example.vatsal;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vatsal.model.Resume;

public class MainActivity extends AppCompatActivity {

    EditText nameEdit, emailEdit, linkedInEdit, skillsEdit, educationEdit;
    Button previewButton, selectPhotoButton;
    ImageView profileImageView;
    Uri selectedImageUri = null;

    ActivityResultLauncher<String> imagePickerLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        nameEdit = findViewById(R.id.editTextName);
        emailEdit = findViewById(R.id.editTextEmail);
        linkedInEdit = findViewById(R.id.editTextLinkedIn);
        skillsEdit = findViewById(R.id.editTextSkills);
        educationEdit = findViewById(R.id.editTextEducation);
        previewButton = findViewById(R.id.buttonPreview);
        selectPhotoButton = findViewById(R.id.buttonSelectPhoto);
        profileImageView = findViewById(R.id.imageViewProfile);

        // Image picker launcher
        imagePickerLauncher = registerForActivityResult(
                new ActivityResultContracts.GetContent(),
                uri -> {
                    if (uri != null) {
                        selectedImageUri = uri;
                        profileImageView.setImageURI(uri);
                    }
                }
        );

        selectPhotoButton.setOnClickListener(v -> {
            imagePickerLauncher.launch("image/*");
        });

        previewButton.setOnClickListener(v -> {
            // Collect input
            String name = nameEdit.getText().toString();
            String email = emailEdit.getText().toString();
            String linkedIn = linkedInEdit.getText().toString();
            String skills = skillsEdit.getText().toString();
            String education = educationEdit.getText().toString();

            Resume resume = new Resume(name, email, linkedIn, skills, education);

            Intent intent = new Intent(MainActivity.this, ResumePreviewActivity.class);
            intent.putExtra("resume", resume);

            // Pass image URI string if selected
            if (selectedImageUri != null) {
                intent.putExtra("imageUri", selectedImageUri.toString());
            }

            startActivity(intent);
        });
    }
}
