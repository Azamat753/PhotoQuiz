package com.lawlett.photoquiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.lawlett.photoquiz.data.Level
import com.lawlett.photoquiz.databinding.FragmentStartBinding
import com.lawlett.photoquiz.utils.LevelPreference
import com.lawlett.photoquiz.utils.StartPreference
import com.lawlett.photoquiz.viewmodels.GameViewModel
import org.koin.android.ext.android.inject

class StartFragment : BaseFragment(R.layout.fragment_start) {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    private val viewModel by inject<GameViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkDataBase()
        LevelPreference.getInstance(requireContext())!!.clearShown()

    }

    private fun checkDataBase() {
        var isShown: Boolean = StartPreference.getInstance(requireContext())!!.isShown
        if (isShown) {
            binding.startBtn.setOnClickListener {
                findNavController().navigate(R.id.action_startFragment_to_levelsFragment)
            }
        } else {
            insertToDataBase()
        }
    }

    private fun insertToDataBase() {
        binding.startBtn.setOnClickListener {
            val firstLevel = Level(
                id = 1,
                firstImg = "https://upload.wikimedia.org/wikipedia/commons/c/ca/Microphone_studio.jpg",
                secondImg = "https://img.global.news.samsung.com/ru/wp-content/uploads/2020/04/KV-notext.jpg",
                thirdImg = "https://i.mycdn.me/i?r=AEE-HZfz734vGAKlsp5gLh-pQ0e66eKYS1lEH4dKCDbkbpsaYV3Kk5HSLDfCIWlmrGrehZAV638o6OqI7JEuxlI9&fn=external_8",
                fourImg = "https://bigpicture.ru/wp-content/uploads/2018/12/26_picture_5655b6fbdd5ec755478101_fishkithumbf3n_jpg.jpg",
                answer = "Чайник"
            )
            val secondLevel = Level(
                id = 2,
                firstImg = "https://knews.kg/wp-content/uploads/2019/09/181c200ab42b9f6c6b850a2b50ec764c.png",
                secondImg = "https://lh3.googleusercontent.com/proxy/UZ02CsKytpYAKX-2KmuMBthDpYnyCD-9S8LCeerGS1RF655Hn1SliAX5w4K3O6uHR-PCVc_sVZn3xq4FKw",
                thirdImg = "https://image.arrivalguides.com/415x300/09/eb6d57d0ca38091b96329f5b11d182a6.jpg",
                fourImg = "https://avatarko.ru/img/kartinka/2/serdce_eda_frukt_yabloko_1821.jpg",
                answer = "Рыскуль"
            )
            val thirdLevel = Level(
                id = 3,
                firstImg = "https://www.yesasia.ru/wp-content/uploads/2017/09/14515767_1796338440645835_2385598692179574784_n.jpg",
                secondImg = "https://techrocks.ru/wp-content/uploads/2020/01/animal-wildlife-portrait-green-botany-reptile-771261-pxhere.com-min.jpg",
                thirdImg = "data:image/jpeg;base64,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",
                fourImg = "https://vzboltay.com/uploads-retina/posts/2018-02/1517827134_izvestnye-marki-viski-2.jpg",
                answer = "Адилет"
            )
            val fourLevel = Level(
                id = 4,
                firstImg = "https://www.questionpro.com/blog/wp-content/uploads/2017/02/Multi-Language.jpg",
                secondImg = "https://proforientator.ru/publications/articles/New%20Folder/setevoy_vrach1.jpg",
                thirdImg = "https://asiapoisk.com/uploads/cache/doramas2/15641367695d3ad5418cb3e7.96133143_wnBPNf-450x900.jpg",
                fourImg = "https://www.examen.ru/assets/images/2018/20180213_brand_manager_1.jpg",
                answer = "Бусажида"
            )
            val fiveLevel = Level(
                id = 5,
                firstImg = "https://ru.hellomagazine.com/images/2014/december/editors/dasha/mandarin24122014-fix.jpg",
                secondImg = "https://medworldclinic.com/wp-content/uploads/2019/07/medworld-clinic-Hollywood-Smile-3-1024x683.jpg",
                thirdImg = "https://kulinarnia.ru/wp-content/uploads/2017/03/baunti-v-domashnikh-usloviyakh.jpg",
                fourImg = "https://www.meme-arsenal.com/memes/b43fe77b0c759370a7a2a7ccc60b09d3.jpg",
                answer = "Миранда"
            )
            val sixLevel = Level(
                id = 6,
                firstImg = "https://www.firestock.ru/wp-content/uploads/2015/06/new-manager-700x635.jpg",
                secondImg = "https://avatars.mds.yandex.net/get-dialogs/399212/f69144dc38595b6129cd/orig",
                thirdImg = "https://lh3.googleusercontent.com/proxy/RO4KN3dgf-b9mAtXacveViw4qORaiMKbsxCxvKFupDZzqHhfL5FOp074HfVhij86sPiGcfTzyfQg5RJbdV4M",
                fourImg = "https://media.1istochnik.ru/attachments/istochnik/publications/0/9034/large_1478262950-5572de69a2.jpg",
                answer = "Кузя"
            )
            val sevenLevel = Level(
                id = 7,
                firstImg = "https://static.wikia.nocookie.net/pokemon/images/4/49/Ash_Pikachu.png/revision/latest?cb=20200405125039",
                secondImg = "https://vostokmedia.com/attachments/279730ec90272239ac0e6a4e1d3f1af5ba581fd1/store/fill/360/200/42963280708bc03ec773f1d7a29e0c736501258e55f9e3a601219bf80eb6/42963280708bc03ec773f1d7a29e0c736501258e55f9e3a601219bf80eb6.jpg",
                thirdImg = "https://grandkulinar.ru/uploads/posts/2020-07/1594046244_holodnyj-kofe-so-ldom.jpg",
                fourImg = "https://watchesmaster.ru/uploads/cache/CatalogProducts/images_34656/c411e6_w1220.jpg",
                answer = "Алтынай"
            )
            val eightLevel = Level(
                id = 8,
                firstImg = "https://s2.eda.ru/StaticContent/Photos/120131082439/160124115932/p_O.jpg",
                secondImg = "https://kanzashi.com.ua/data/big/rezi2nka_8.jpg",
                thirdImg = "https://helperia.ru/public/images/articles/thumb/6/69/%D0%9C%D0%B0%D1%81%D1%81%D0%B0%D0%B6%D0%B8%D1%81%D1%82.jpeg/300px-%D0%9C%D0%B0%D1%81%D1%81%D0%B0%D0%B6%D0%B8%D1%81%D1%82.jpeg",
                fourImg = "https://barber-shop.su/wp-content/uploads/2019/02/strizhka-borody-v-moskve.jpg",
                answer = "Аъзамжон"
            )
            val nineLevel = Level(
                id = 9,
                firstImg = "https://static8.depositphotos.com/1034582/928/i/600/depositphotos_9288609-stock-photo-tortoise-on-a-laptop-computer.jpg",
                secondImg = "https://upload.wikimedia.org/wikipedia/commons/c/c3/%D0%9F%D0%B0%D1%82%D1%80%D0%B8%D0%B0%D1%80%D1%85_%D0%9A%D0%B8%D1%80%D0%B8%D0%BB%D0%BB_%D0%BD%D0%B0_%D0%B2%D1%81%D1%82%D1%80%D0%B5%D1%87%D0%B5_%D1%81_%D0%9F%D0%B0%D1%82%D1%80%D0%B8%D0%B0%D1%80%D1%85%D0%BE%D0%BC_%D0%A4%D0%B5%D0%BE%D1%84%D0%B8%D0%BB%D0%BE%D0%BC_III_%D0%B8_%D0%92%D0%BB%D0%B0%D0%B4%D0%B8%D0%BC%D0%B8%D1%80%D0%BE%D0%BC_%D0%9F%D1%83%D1%82%D0%B8%D0%BD%D1%8B%D0%BC.jpg",
                thirdImg = "https://cdnimg.rg.ru/img/content/170/31/46/1_d_850.jpg",
                fourImg = "https://d34gu9h9mtzjxz.cloudfront.net/lib/profiles/8712/hall_portfolio/p_8712_11541_89945f5a79180742cf390202f1f373013d81db1c_x3.jpg",
                answer = "Руслан"
            )
            val tenLevel = Level(
                id = 10,
                firstImg = "https://gdb.rferl.org/D9E9DB28-721D-4A07-964F-62C79F792D47_cx0_cy11_cw0_w1080_h608.jpg",
                secondImg = "https://bohenon.com/uploads/images/pages/4728401903fee9fc83ba8cf48a29207205323ef2.jpeg",
                thirdImg = "https://st2.depositphotos.com/1035649/7783/v/450/depositphotos_77833060-stock-illustration-%D1%8D%D0%BC%D0%B1%D0%BB%D0%B5%D0%BC%D0%B0-%D1%80%D0%B5%D1%81%D1%82%D0%BE%D1%80%D0%B0%D0%BD%D0%B0.jpg",
                fourImg = "https://spark.ru/upload/other/b_569d17e6aa5cf.jpg",
                answer = "Адилхан"
            )
            val elevenLevel = Level(
                id = 11,
                firstImg = "https://ubi-hall.com.ua/wp-content/uploads/2018/12/%D1%81%D0%BF%D0%B8%D0%BA%D0%B5%D1%80.jpg",
                secondImg = "https://image.freepik.com/free-photo/vape-man-the-modern-young-person-produces-clouds-of-vapor_97245-124.jpg",
                thirdImg = "https://sales-generator.ru/upload/resize_cache/iblock/b1d/790_395_2/xb1d83be7ae5a6da06c84325d0d7606d9.jpg.pagespeed.ic.dF1jDjSQY7.jpg",
                fourImg = "https://foodbay.com/wiki/wp-content/uploads/2020/08/c8fd26f982-2.png",
                answer = "Айдар"
            )
            val twelveLevel = Level(
                id = 12,
                firstImg = "https://www.buro247.ua/thumb/670x830_0/images/2020/06/emily-ratajkowski-blond-hair-01-01.jpg",
                secondImg = "https://lh3.googleusercontent.com/proxy/h31tPlSjFYV8-YyyFArVlF6u7xE9oYlSd58RFXy2EnVNBZ4PXmL9R-BhNrj7BZLLXbKYdqLoqUzbZh0EEt_4WhfwySSlCdYj__QHD6Mb8xdJ1NCVRPepnw",
                thirdImg = "https://stihi.ru/pics/2016/05/08/813.jpg",
                fourImg = "https://avatars.mds.yandex.net/get-zen_doc/163385/pub_5cd2acb53c1e9b00b3aa9c61_5cd2d9d9c5fa2a00b4266494/scale_1200",
                answer = "Ая"
            )
            val thirteenLevel = Level(
                id = 13,
                firstImg = "https://i.ytimg.com/vi/NxAgJSeVZqI/maxresdefault.jpg",
                secondImg = "https://i.ytimg.com/vi/CY8sO56AF7U/maxresdefault.jpg",
                thirdImg = "https://www.foroffice.ru/upload/iblock/626/3.jpg",
                fourImg = "https://contents.mediadecathlon.com/p1521303/k1d67bc05aa94bf36c171523f7fe7d0a5/1521303_default.jpg?format=auto&quality=60&f=800x0",
                answer = "Талгар"
            )
            val fourteenLevel = Level(
                id = 14,
                firstImg = "https://top-barbershop.com/media/2019/04/long-undercut-top-knot.jpg",
                secondImg = "https://uanp.org.ua/wp-content/uploads/2019/04/cWcR-_T2_400x400.jpg",
                thirdImg = "https://sun9-76.userapi.com/c1214/g793271/a_062573a1.jpg?ava=1",
                fourImg = "https://i.ytimg.com/vi/DW7Vvp-N9CA/maxresdefault.jpg",
                answer = "Тилек"
            )
            val fiveteenLevel = Level(
                id = 15,
                firstImg = "https://avatars.mds.yandex.net/get-kinopoisk-image/1777765/a5f2476b-542e-47f4-bf2c-e8a803953400/360",
                secondImg = "https://img.rosbalt.ru/photobank/9/2/0/d/wkh8Wxpt-580.jpg",
                thirdImg = "https://stoneforest.ru/wp-content/uploads/2015/05/Heineken-beer-1.jpg",
                fourImg = "https://static.news.ru/photo/896085dd-f6c0-48c1-a387-7cbcc49ca0c9_1200.jpg",
                answer = "Жакшылык"
            )
            val sixteenLevel = Level(
                id = 16,
                firstImg = "https://avartik.ru/upload/000/u6/d/e/76467681.jpg",
                secondImg = "https://rustars.tv/wp-content/uploads/2017/09/azamat-musagaliev2.jpg",
                thirdImg = "https://www.belcanto.ru/media/images/term/14092012.jpg",
                fourImg = "https://st2.depositphotos.com/1757583/11212/i/950/depositphotos_112127610-stock-photo-kyrgyzstan-flag-with-russia-flag.jpg",
                answer = "Алика"
            )
            val seventeenLevel = Level(
                id = 17,
                firstImg = "https://upload.wikimedia.org/wikipedia/commons/thumb/1/19/WhatsApp_logo-color-vertical.svg/1024px-WhatsApp_logo-color-vertical.svg.png",
                secondImg = "",
                thirdImg = "",
                fourImg = "",
                answer = "Жамалдин"
            )
            val eighteenLevel = Level(
                id = 18,
                firstImg = "https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/%D0%91%D0%B0%D0%BD%D0%BA%D0%BE%D0%BC%D0%B0%D1%82_%D0%A1%D0%B1%D0%B5%D1%80%D0%B1%D0%B0%D0%BD%D0%BA%D0%B0.jpg/270px-%D0%91%D0%B0%D0%BD%D0%BA%D0%BE%D0%BC%D0%B0%D1%82_%D0%A1%D0%B1%D0%B5%D1%80%D0%B1%D0%B0%D0%BD%D0%BA%D0%B0.jpg",
                secondImg = "https://upload.wikimedia.org/wikipedia/commons/9/96/Google_web_search.png",
                thirdImg = "https://i.ytimg.com/vi/362l2H6O-sw/maxresdefault.jpg",
                fourImg = "https://s.drom.ru/4/reviews/photos/toyota/avensis/big_83603_1.jpg",
                answer = "Нургазы"
            )
            val nineteenLevel = Level(
                id = 19,
                firstImg = "https://miro.medium.com/max/1200/1*FpIHfX50Sw7-FOTnRMWZaQ.png",
                secondImg = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUGBXlcHgyVAo7ulOAsMs4u3B-6eRhGikYhA&usqp=CAU",
                thirdImg = "https://img5.lalafo.com/i/posters/original/84/a3/7e/3a2e820d480fd4fc96756fdbfe.jpeg",
                fourImg = "https://upload.wikimedia.org/wikipedia/commons/b/b9/Football_iu_1996.jpg",
                answer = "Бакыт"
            )
            val twentyLevel = Level(
                id = 20,
                firstImg = "https://www.revizor.kg/wp-content/uploads/2019/05/32dc9d24-de7d-4f3a-b416-cd889a49155b.jpg",
                secondImg = "https://www.akchabar.kg/media/news/ce73d5f6-0997-4804-97a2-d93394034958.JPG.850x445_q82_crop.jpg",
                thirdImg = "https://d2xzmw6cctk25h.cloudfront.net/geekbrains/public/ckeditor_assets/pictures/8749/retina-de697f3823c7007073876907190c5ba5.jpg",
                fourImg = "https://altufevo.ru/i/torty/podarochnye-torty/podarochnyj-tort-rajskoe-yablochko-490_800x600.jpg",
                answer = "Рустам"
            )
            viewModel.addLevel(firstLevel)
            viewModel.addLevel(secondLevel)
            viewModel.addLevel(thirdLevel)
            viewModel.addLevel(fourLevel)
            viewModel.addLevel(fiveLevel)
            viewModel.addLevel(sixLevel)
            viewModel.addLevel(sevenLevel)
            viewModel.addLevel(eightLevel)
            viewModel.addLevel(nineLevel)
            viewModel.addLevel(tenLevel)
            viewModel.addLevel(elevenLevel)
            viewModel.addLevel(twelveLevel)
            viewModel.addLevel(thirteenLevel)
            viewModel.addLevel(fourteenLevel)
            viewModel.addLevel(fiveteenLevel)
            viewModel.addLevel(sixteenLevel)
            viewModel.addLevel(seventeenLevel)
            viewModel.addLevel(eighteenLevel)
            viewModel.addLevel(nineteenLevel)
            viewModel.addLevel(twentyLevel)
            StartPreference.getInstance(requireContext())!!.saveShown()
            findNavController().navigate(R.id.action_startFragment_to_levelsFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}