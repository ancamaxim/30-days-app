package com.example.a30daysofmountainhikes

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

class Datasource {
    @Composable
    fun loadHikes(): List<Hike> {
        return listOf(
            Hike(
                R.drawable.sinaiasaua_varfului_cu_dorcabana_padina,
                R.string.sinaia_saua_varfului_cu_dor_cabana_padina,
                "mediu / dificil",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_sinaia_padina),
                1
            ),
            Hike(
                R.drawable.sinaia_cabana_omu_rasnov,
                R.string.sinaia_cabana_omu_rasnov,
                "mediu / dificil",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_sinaia_omu_rasnov),
                2
            ),
            Hike(
                R.drawable.poiana_apului___cabana_st_na_regal,
                R.string.poiana_tapului_cabana_stana_regala,
                "usor / mediu",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_poiana_stana),
                3
            ),
            Hike(
                R.drawable.poiana_apului___cascada_urlatoarea,
                R.string.poiana_tapului_cascada_urlatoarea,
                "usor / mediu",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_poiana_urlatoarea),
                4
            ),
            Hike(
                R.drawable.bran___poiana_gaura___cabana_omu,
                R.string.bran_cabana_omu,
                "mediu / dificil",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_bran_omu),
                5
            ),
            Hike(
                R.drawable.moieciu_de_sus___aua_batr_na___hotel_petera,
                R.string.moieciu_pestera,
                "mediu / dificil",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_moieciu_pes),
                6
            ),
            Hike(
                R.drawable.moroeni___plaiul_priporului___cabana_scropoasa,
                R.string.moroeni_scropoasa,
                "mediu",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_moroeni_scropoasa),
                7
            ),
            Hike(
                R.drawable.cabana_curmtura_vf__la_om_podu_d_mboviei,
                R.string.curmatura_podu_dambovitei,
                "dificil",
                "Piatra Craiului",
                info = stringResource(R.string.info_piatra_craiului),
                8
            ),
            Hike(
                R.drawable.casa_folea_prpstiile_zrnetilor,
                R.string.casa_folea,
                "usor / mediu",
                "Piatra Craiului",
                info = stringResource(R.string.info_casa_folea),
                8
            ),
            Hike(
                R.drawable.cormaia___valea_cormaia___aua_ob_ria_rebrii,
                R.string.cormaia,
                "mediu",
                "Rodnei",
                info = stringResource(R.string.info_rodnei),
                9
            ),
            Hike(
                R.drawable.cheia___vf__gropoarele___cabana_vf__ciuca,
                R.string.cheia,
                "mediu / dificil",
                "Ciucas",
                info = stringResource(R.string.info_ciucas),
                10
            ),
            Hike(
                R.drawable.poiana_st_nii___culmea_gropoarele___zganu,
                R.string.poiana_stanii,
                "mediu / dificil",
                "Ciucas",
                info = stringResource(R.string.info_poiana_stanii),
                11
            ),
            Hike(
                R.drawable.casa_de_v_ntoare_c_mpuel___piatra_iorgovanului___lunca_berhina,
                R.string.casa_de_vanatoare,
                "mediu",
                "Retezat",
                info = stringResource(R.string.info_retezat1),
                12
            ),
            Hike(
                R.drawable.lacul_bucura___poarta_bucurei___sub_v_rful_bucura___custura_retezatului___v_rful_retezat,
                R.string.lacul_bucura,
                "mediu",
                "Retezat",
                info = stringResource(R.string.info_retezat2),
                13
            ),
            Hike(
                R.drawable.r_uor___lacul_tevia__v_rful_retezat,
                R.string.rausor,
                "mediu",
                "Retezat",
                info = stringResource(R.string.info_retezat3),
                14
            ),
            Hike(
                R.drawable.lunca_berhina___crucea_trznitului___lacul_bucura,
                R.string.lunca_berhina,
                "mediu",
                "Retezat",
                info = stringResource(R.string.info_retezat4),
                15
            ),
            Hike(
                R.drawable.circuitul_lacurilor,
                R.string.circuitul_lacurilor,
                "mediu",
                "Retezat",
                info = stringResource(R.string.info_retezat5),
                16
            ),
            Hike(
                R.drawable.cabana_b_lea_cascad___cascada_b_lea,
                R.string.cabana_balea,
                "usor",
                "Fagaras - Iezer - Papusa",
                info = stringResource(R.string.info_fagaras1),
                17
            ),
            Hike(
                R.drawable.vf__vitea_mare___vf__moldoveanu,
                R.string.vistea_mare,
                "mediu / dificil",
                "Fagaras - Iezer - Papusa",
                info = stringResource(R.string.info_fagaras2),
                18
            ),
            Hike(
                R.drawable.buteni___cabana_piatra_ars,
                R.string.busteni,
                "mediu / dificil",
                "Bucegi - Leaota",
                info = stringResource(R.string.info_busteni),
                19
            ),
            Hike(
                R.drawable.zarnesti_prapastiile_zarnesti,
                R.string.zarnesti_prapastiile,
                "ușor",
                "Piatra Craiului",
                info = stringResource(R.string.zarnesti_prapastiile_info),
                20
            ),
            Hike(
                R.drawable.cheile_cibului,
                R.string.cheile_cibului_ardeu,
                "mediu",
                "Trascău",
                info = stringResource(R.string.cheile_cibului_ardeu_info),
                21
            ),
            Hike(
                R.drawable.dn7e68,
                R.string.rosia_noua,
                "mediu",
                "Zarand",
                info = stringResource(R.string.rosia_noua_info),
                22
            ),
            Hike(
                R.drawable.comandau,
                R.string.comandau_refugiul,
                "mediu",
                "Vrancei",
                info = stringResource(R.string.comandau_refugiul_info),
                23
            ),
            Hike(
                R.drawable.stana_carnituri,
                R.string.carnituri_vidreni,
                "mediu",
                "Bucegi",
                info = stringResource(R.string.carnituri_vidreni_info),
                24
            ),
            Hike(
                R.drawable.cluj_napoca,
                R.string.padurea_hoia,
                "ușor",
                "Apuseni",
                info = stringResource(R.string.padurea_hoia_info),
                25
            ),
            Hike(
                R.drawable.bretcu,
                R.string.bretcu_oituz,
                "ușor / mediu",
                "Nemira",
                info =stringResource( R.string.bretcu_oituz_info),
                26
            ),
            Hike(
                R.drawable.poiana_cozanei,
                R.string.piatra_cu_semne,
                "ușor",
                "Mehedinți",
                info = stringResource(R.string.piatra_cu_semne_info),
                27
            ),
            Hike(
                R.drawable.chiojdu,
                R.string.chiojdu_trovanti,
                "ușor",
                "Buzău",
                info = stringResource(R.string.chiojdu_trovanti_info),
                28
            ),
            Hike(
                R.drawable.rezervatia_paleontologica,
                R.string.purcareni_fosile,
                "ușor",
                "Postăvaru",
                info = stringResource(R.string.purcareni_fosile_info),
                29
            ),
            Hike(
                R.drawable.poiana_marului,
                R.string.pietrele_scorilo,
                "mediu",
                "Țarcu",
                info = stringResource(R.string.pietrele_scorilo_info),
                30
            )
        )
    }
}
