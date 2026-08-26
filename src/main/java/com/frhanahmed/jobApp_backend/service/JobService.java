package com.frhanahmed.jobApp_backend.service;


import com.frhanahmed.jobApp_backend.model.JobPost;
import com.frhanahmed.jobApp_backend.repo.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepo jobRepo;

    public void addJob(JobPost jobPost){
//        jobRepo.addJob(jobPost);
        jobRepo.save(jobPost);
    }


    public List<JobPost> getAllJobs(){
//        return jobRepo.getAllJobs();
        return jobRepo.findAll();
    }

    public JobPost getJob(int postId) {
//        return jobRepo.getJob(postId);
        return jobRepo.findById(postId).orElse(new JobPost());
    }

    public void updateJob(JobPost jobPost) {
//        jobRepo.updateJob(jobPost);
        jobRepo.save(jobPost);
    }

    public void deleteJob(int postId) {
//        jobRepo.deleteJob(postId);
        jobRepo.deleteById(postId);
    }
    public void load() {
        List<JobPost> jobs =
                new ArrayList<>(List.of(
                        new JobPost(1, "Java Developer", "Responsible for building robust backend services, microservices, and enterprise applications.", 3, List.of("Java", "Spring Boot", "Hibernate", "PostgreSQL")),
                        new JobPost(2, "Python Developer", "Develop scalable backend REST APIs, automation pipelines, and core business logic.", 2, List.of("Python", "Django", "FastAPI", "Docker")),
                        new JobPost(3, "React Developer", "Create interactive, dynamic, and modern single-page applications with high performance.", 2, List.of("React", "JavaScript", "TypeScript", "Tailwind CSS", "Redux")),
                        new JobPost(4, "Full Stack Developer", "Design and maintain end-to-end web applications across the entire frontend and backend lifecycle.", 4, List.of("Java", "Spring Boot", "React", "SQL", "Docker")),
                        new JobPost(5, "Machine Learning Engineer", "Design, train, and deploy predictive models and deep learning pipelines into production.", 3, List.of("Python", "PyTorch", "TensorFlow", "Scikit-Learn", "MLflow")),
                        new JobPost(6, "Data Scientist", "Analyze large complex datasets, extract actionable insights, and build statistical learning models.", 4, List.of("Python", "R", "SQL", "Pandas", "Tableau")),
                        new JobPost(7, "Software Developer", "Write clean, testable code and contribute to core architecture and software modules.", 2, List.of("Java", "Data Structures", "Algorithms", "Git", "REST APIs")),
                        new JobPost(8, "Software Engineer", "Exciting opportunity for a skilled software engineer to design resilient distributed systems.", 3, List.of("Java", "Spring", "SQL", "AWS", "Microservices")),
                        new JobPost(9, "Frontend Developer", "Build responsive, accessible, and high-quality user interfaces with modern web standards.", 2, List.of("HTML5", "CSS3", "JavaScript", "React", "Vite")),
                        new JobPost(10, "Backend Developer", "Architect scalable server-side systems, secure endpoints, and optimize database performance.", 3, List.of("Java", "Spring Boot", "Kafka", "MySQL", "Redis")),
                        new JobPost(11, "Node.js Developer", "Build event-driven asynchronous services, RESTful APIs, and real-time backend engines.", 3, List.of("Node.js", "Express.js", "MongoDB", "TypeScript", "WebSocket"))
                ));
        jobRepo.saveAll(jobs);
    }
    public List<JobPost> search(String keyword) {
        return jobRepo.findByPostProfileContainingOrPostDescContaining(keyword,keyword);
    }
}
