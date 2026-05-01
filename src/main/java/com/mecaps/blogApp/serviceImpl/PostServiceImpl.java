package com.mecaps.blogApp.serviceImpl;

import com.mecaps.blogApp.Exception.ResourcrsNotFoundException;
import com.mecaps.blogApp.entity.Post;
import com.mecaps.blogApp.entity.Users;
import com.mecaps.blogApp.repository.PostRepository;
import com.mecaps.blogApp.repository.UsersRepository;
import com.mecaps.blogApp.requestDTO.PostRequestDTO;
import com.mecaps.blogApp.responseDTO.PostResponseDTO;
import com.mecaps.blogApp.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private UsersRepository usersRepository;

    public PostServiceImpl(PostRepository postRepository, UsersRepository usersRepository){
        this.postRepository= postRepository;
        this.usersRepository= usersRepository;
    }


    @Override
    public PostResponseDTO createPost(PostRequestDTO requestDTO) {
        Users user = usersRepository.findById(requestDTO.getAuthorId()).orElseThrow(
                () -> new RuntimeException("User id not found  : " + requestDTO.getAuthorId())
        );
        Post post = new Post();
        post.setContent(requestDTO.getContent());
        post.setAuthor(user);
        Post savePost = postRepository.save(post);
        return new PostResponseDTO(savePost);
    }



    @Override
    public List<PostResponseDTO> findPostByAuthorId(Long id) {
        List<Post> allPostOfUser = postRepository
                .findByAuthor_Id(id);
        if (allPostOfUser.isEmpty())
            throw new ResourcrsNotFoundException("Post id not found" + id);
        return allPostOfUser.stream().map(PostResponseDTO::new).toList();
    }

    @Override
    public List<PostResponseDTO> getAllPost(){
        List<Post> all = postRepository.findAll();
        if (all.isEmpty())
            throw new ResourcrsNotFoundException("Post data is null");
        return all.stream().map(PostResponseDTO::new).toList();
    }

    @Override
    public PostResponseDTO updatePost(Long postId, PostRequestDTO requestDTO){

        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourcrsNotFoundException("Post id not found : " + postId));

        post.setContent(requestDTO.getContent());
        Post save = postRepository.save(post);
        return new PostResponseDTO(save);

    }




    @Override
    public String deletePostById(Long id){

        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Post id not found : " + id));


        postRepository.delete(post);
        return "Deleted post...!";
    }


}
