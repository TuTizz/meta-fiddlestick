LICENSE = "CLOSED"

NFTABLES_CONF_FILE ?= ""
RDEPENDS_{PN}="nftables"
FILES_${PN} += " \
	${sysconfdir}/nftables/nftables.rules \
"

python () {
    if d.getVar('NFTABLES_CONF_FILE') == '' or not os.path.isfile(d.getVar('NFTABLES_CONF_FILE')) :
        bb.fatal("ERROR: NFTABLES_CONF_FILE variable is set to invalid value file does not exist : %s. Change your local.conf to put NFTABLES_CONF_FILE=\"<file>\" if needed, copy the one available in this subfolder." % d.getVar('NFTABLES_CONF_FILE'))
    else :
        d.setVar('SRC_URI', "file://" + d.getVar('NFTABLES_CONF_FILE'))
}

do_install() {
	install -d ${D}${sysconfdir}/nftables
	install -m 0644 ${NFTABLES_CONF_FILE} ${D}${sysconfdir}/nftables/nftables.rules
}

