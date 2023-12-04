package com.example.vamostcc.view.telaprincipal.ui.video

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import com.example.vamostcc.R
import com.example.vamostcc.databinding.FragmentVideoTreinosBinding
import com.example.vamostcc.view.frmlogin.frmLogin
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class videoTreinos : Fragment() {

    private var _binding: FragmentVideoTreinosBinding? = null
    private val binding get() = _binding!!

    private val auth = FirebaseAuth.getInstance()
    private var db = FirebaseFirestore.getInstance()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoTreinosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        abrirVideo()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun abrirVideo() {

        val idUsuario = FirebaseAuth.getInstance().currentUser!!.uid
        val ref = db.collection("usuarios").document(idUsuario)

        var videoView = binding.videoSelecionado

        var mediaController = MediaController(requireContext())
        videoView.setMediaController(mediaController)

        ref.get().addOnSuccessListener { document ->
            var video = document["video"].toString()

            if (document != null) {

                if (video == "video1" ){

                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supinoretobarra
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Deite-se sobre um banco reto com os joelhos flexionados e os pés firmes no chão ou no suporte.\n" +
                                "Com as costas levemente arqueadas e os glúteos bem estabilizados no banco, pegue a barra a uma distância maior do que a dos ombros.\n" +
                                "Então, levante o peso do suporte e o segure na linha do peito com os cotovelos estendidos. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Com os punhos retos, desça a barra de maneira controlada até a altura do peito, flexionando os cotovelos para baixo.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Depois de uma pequena pausa, empurre a barra para cima, concentrando a força nos músculos do peito e não nos braços.\n" +
                                "Mantenha os ombros para trás e as escápulas fixas no banco enquanto executa esta parte do movimento.\n" +
                                "Quando terminar as repetições, coloque a barra com cuidado novamente no suporte. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )



                } else if(video == "video2"){

                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_inclinado_barra
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco com inclinação entre 30 e 45 graus com os pés firmes no chão ou no suporte.\n" +
                                "Com as costas levemente arqueadas, pegue a barra a uma distância maior do que a dos ombros.\n" +
                                "Tire o peso do suporte e o estabilize na linha de cima do peito com os cotovelos estendidos. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Mantendo os punhos retos, desça a barra, de maneira controlada, até a parte superior dos músculos peitorais.\n" +
                                "Realize este movimento flexionando os cotovelos para baixo enquanto abre o peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Depois de uma pequena pausa, empurre a barra para cima, concentrando a força na parte superior dos músculos do peito.\n" +
                                "Mantenha os ombros para trás e as escápulas fixas no banco enquanto executa esta parte do movimento.\n\n" +
                                "Quando terminar as repetições, coloque a barra novamente no suporte com cuidado. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )



                } else if (video == "video3"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_declinado_barra
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Firme as pernas no suporte de um banco declinado e deite-se sobre ele.\n" +
                                "Com as costas bem estabilizadas no banco, pegue a barra a uma distância maior do que a dos ombros.\n" +
                                "Então, levante o peso do suporte e o segure na linha do peito com os cotovelos estendidos. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Mantendo os punhos retos, desça a barra, de maneira controlada, até a parte inferior dos músculos peitorais.\n" +
                                "Realize este movimento flexionando os cotovelos para baixo enquanto abre o peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Depois de uma pequena pausa, empurre a barra para cima, concentrando a força na parte inferior dos músculos do peito.\n" +
                                "Segure o peito contraído por um instante e então desça a barra novamente.\n" +
                                "Quando terminar as repetições, coloque a barra novamente no suporte com cuidado. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )

                } else if(video == "video4"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_reto_halter
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco reto com um halter apoiado em cada coxa.\n" +
                                "Com a ajuda das pernas, suba os pesos enquanto deita o corpo para trás. Firme bem as costas e os glúteos no banco.\n" +
                                "Então, segure os halteres próximos um do outro, na linha do peito, com os cotovelos estendidos. A pegada deve ser com os polegares virados para dentro. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, desça os halteres controladamente, flexionando os cotovelos para baixo até os pesos ficarem na altura do peito.\n" +
                                "Alongue bem os músculos da região peitoral enquanto realiza esta parte do movimento.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Empurre os pesos para cima, aproximando os halteres um do outro até os cotovelos ficarem estendidos.\n" +
                                "Concentre a força nos músculos peitorais, subindo somente os braços. Os ombros permanecem encaixados para trás.\n\n" +
                                "Quando terminar, gire os halteres e os apoie nas pernas enquanto volta para a posição sentada. Então, coloque os halteres no solo com segurança."
                    )

                } else if(video == "video5"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_inclinado_halter
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco com inclinação entre 30 e 45 graus com um halter apoiado em cada coxa.\n" +
                                "Com a ajuda das pernas, suba os pesos e firme as costas no encosto do banco.\n" +
                                "Então, segure os halteres próximos um do outro na linha do peito com os cotovelos estendidos.\n" +
                                "A pegada deve ser com os polegares virados para dentro. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, desça os halteres de forma controlada, flexionando os cotovelos para baixo até os pesos ficarem na altura da parte superior do peito.\n" +
                                "Alongue bem os músculos peitorais enquanto realiza esta parte do movimento.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Empurre os pesos para cima, aproximando os halteres um do outro, até os cotovelos ficarem estendidos.\n" +
                                "Concentre a força no peito, subindo somente os braços. Os ombros permanecem encaixados para trás.\n\n" +
                                "Quando terminar, apoie os halteres nas coxas para colocá-los no chão com segurança."
                    )

                } else if(video == "video6"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_declinado_halter
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Firme as pernas no suporte de um banco declinado e deite-se sobre ele.\n" +
                                "Estabilize as costas no banco e segure os halteres próximos um do outro, na linha do peito, com os cotovelos estendidos.\n" +
                                "A pegada deve ser com os polegares virados para o dentro. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, desça os halteres de maneira controlada, flexionando os cotovelos para baixo até os pesos ficarem na altura do peito.\n" +
                                "Alongue bem os músculos peitorais enquanto realiza esta parte do movimento.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Empurre os pesos para cima, aproximando os halteres um do outro até os cotovelos ficarem estendidos.\n" +
                                "Segure o peito contraído por um instante e então desça os pesos novamente.\n\n" +
                                "Quando terminar as repetições, retire-se do banco com cuidado. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )

                } else if(video ==  "video7"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_reto_barrag
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco reto posicionado no centro da máquina. A barra deve estar na mesma linha do peito.\n" +
                                "Com as costas arqueadas, pegue a barra a uma distância maior do que a dos ombros.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Mantendo os punhos retos, desça a barra controladamente até a altura do peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Mantenha os ombros para trás e as escápulas fixas no banco enquanto executa esta parte do movimento.\n\n" +
                                "Quando terminar as repetições, trave a barra novamente no suporte. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )

                } else if(video ==  "video8"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.supino_inclinado_barrag
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco com inclinação entre 30 e 45 graus, posicionado no centro da máquina. A barra deve estar na mesma linha do peito.\n" +
                                "Com as costas levemente arqueadas, pegue a barra a uma distância maior do que a dos ombros.\n" +
                                "Tire o peso do suporte e estabilize-o com os cotovelos estendidos. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Mantendo os punhos retos, desça a barra controladamente até a parte superior do peito.\n" +
                                "Realize este movimento flexionando os cotovelos para baixo enquanto abre os músculos peitorais.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Depois de uma pequena pausa, empurre a barra para cima, concentrando a força na parte superior dos músculos do peito.\n" +
                                "Mantenha os ombros para trás e as escápulas fixas no banco enquanto executa esta parte do movimento.\n\n" +
                                "Quando terminar as repetições, trave a barra novamente no suporte. Se necessário, peça para alguém acompanhar você durante todo o exercício."
                    )

                } else if(video ==  "video9"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.crucifixo_sentado
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se no aparelho com as costas fixas no banco e os ombros encaixados para trás. Os pés ficam firmes no chão ou no suporte.\n" +
                                "Agorre os pegadores com as palmas das mãos viradas para frente. Os cotovelos ficam ligeiramente flexionados e os braços paralelos em relação ao chão.\n" +
                                "A altura do banco deve estar ajustada de forma que os pegadores fiquem na mesma altura do peito. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, empurre os pegadores para dentro com a força dos músculos peitorais até eles ficarem bem próximos um do outro.\n" +
                                "Mantenha as costas coladas no banco enquanto realiza esta parte do movimento.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Segure o músculo contraído por um instante e volte os braços para a posição inicial sem mexer os cotovelos."
                    )

                } else if(video ==  "video10"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.crucifixo_reto_halter
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco reto com um halter apoiado em cada coxa. Use as pernas para subir os pesos enquanto deita o corpo para trás.\n" +
                                "Com as costas e os glúteos estabilizados no banco, segure os halteres próximos um do outro, acima do peito, com os cotovelos estendidos.\n" +
                                "A pegada deve ser com as palmas das mãos viradas uma para a outra. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, sem flexionar os cotovelos, desça os pesos abrindo os braços até eles alcançarem a altura do peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Com a força dos músculos peitorais, leve os braços para cima até os pesos ficarem próximos novamente.\n" +
                                "Concentre a força na parte interna do peito, sem tirar as escápulas do banco; elas devem permanecer encaixadas para trás."
                    )

                } else if(video ==  "video11"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.crucifixo_inclinado_halter
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se em um banco com inclinação entre 30 e 45 graus e apoie um halter em cada coxa. Com a ajuda das pernas, suba os pesos enquanto deita o corpo no encosto do banco.\n" +
                                "Com os pés firmes e as costas bem estabilizadas no banco, segure os halteres próximos um do outro na frente do peito com os cotovelos ligeiramente flexionados.\n" +
                                "A pegada deve ser com as palmas das mãos viradas para dentro. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, sem flexionar os cotovelos, desça os pesos abrindo os braços até eles alcançarem a altura do peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Com a força dos músculos peitorais, leve os braços para cima até os pesos ficarem próximos novamente.\n" +
                                "Concentre a força na parte interna do peito e não suba os ombros e as escápulas, eles permanecem encaixados para trás.\n\n" +
                                "Quando completar as repetições, apoie novamente os halteres nas coxas para colocá-los no chão com segurança."
                    )


                } else if(video ==  "video12"){
                    var packageName = "android.resource://" + requireActivity().packageName + "/" + R.raw.crucifixo_articulado_maquina
                    var uri = Uri.parse(packageName)

                    videoView.setVideoURI(uri)
                    videoView.start()

                    binding.txtDescVideo.setText(
                        "- Preparação\n\n" +
                                "Sente-se num banco inclinado posicionado no centro da máquina. As roldanas devem estar no nível mais baixo do aparelho.\n" +
                                "Com as costas bem estabilizadas no banco, segure as alças próximas uma da outra, acima do peito, com os cotovelos estendidos.\n" +
                                "A pegada deve ser com as palmas das mãos viradas uma para a outra. Esta é a posição inicial do exercício.\n\n" +
                                "- Início do Movimento\n\n" +
                                "Agora, sem flexionar os cotovelos, desça os braços até os pegadores alcançarem a altura do peito.\n\n" +
                                "- Final do Movimento\n\n" +
                                "Utilizando a força dos músculos peitorais, leve os braços para cima até as alças ficarem próximas novamente.\n" +
                                "Concentre a força na parte interna do peito, sem tirar as escápulas do banco. Elas permanecem encaixadas para trás.\n\n" +
                                "Depois de segurar a contração por um instante, repita o movimento pelo número necessário de vezes."
                    )

                }
            }
        }.addOnFailureListener {
            Toast.makeText(requireContext(), "erro", Toast.LENGTH_SHORT).show()
        }



    }

}
