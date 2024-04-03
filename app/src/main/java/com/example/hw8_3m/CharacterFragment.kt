package com.example.hw8_3m

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.hw8_3m.databinding.FragmentCharacterBinding


class CharacterFragment : Fragment() {
    private lateinit var binding: FragmentCharacterBinding

    private val listOfRick = arrayListOf(
        CharacterModel(
            "https://avatars.mds.yandex.net/i?id=2aefc7aeedd5d90e59746d6f2f16b49c9e5d5c82-7663592-images-thumbs&n=13",
            "Rick Morty",
            "Alive"
        ),
        CharacterModel(
            "https://avatars.mds.yandex.net/i?id=574f2a7c839059d323d341258761c91bee735a32-9145889-images-thumbs&n=13",
            "Morty Smith",
            "Alive"
        ),
        CharacterModel(
            "https://avatars.mds.yandex.net/i?id=fd17efaf7ae4bc3aef1944c224e0bb6ba3640c72-12645377-images-thumbs&n=13",
            "Albert Einstein",
            "Dead"
        ),
        CharacterModel(
            "https://chillywilly.club/uploads/posts/2023-09/1695743562_chillywilly-club-p-umnii-dzherri-rik-i-morti-art-pinterest-1.jpg",
            "Jerry Smith",
            "Alive"
        ),
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharacterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CharacterAdapter(listOfRick, this::onClick)
        binding.recyclerView.adapter = adapter
    }

    private fun onClick(model: CharacterModel) {
        findNavController().navigate(R.id.signInFragment, bundleOf("character" to model))
    }

}