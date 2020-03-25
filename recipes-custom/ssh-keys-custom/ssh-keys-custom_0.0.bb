LICENSE = "CLOSED"

AUTHORIZED_KEYS ?= ""
RDEPENDS_{PN}="openssh"
FILES_${PN} += " \
    ${ROOT_HOME}/.ssh \
    ${ROOT_HOME}/.ssh/authorized_keys \
"


python () {
    if d.getVar('AUTHORIZED_KEYS') == '' or not os.path.isfile(d.getVar('AUTHORIZED_KEYS')) :
        bb.fatal("ERROR: AUTHORIZED_KEYS variable is set to invalid value file does not exist : %s. Change your local.conf to put AUTHORIZED_KEYS=\"<file>\" ." % d.getVar('AUTHORIZED_KEYS'))
    else :
        d.setVar('SRC_URI', "file://" + d.getVar('AUTHORIZED_KEYS'))
}

do_install() {
    install -d ${D}${ROOT_HOME}/.ssh
    install -m 0644 ${AUTHORIZED_KEYS} ${D}${ROOT_HOME}/.ssh/authorized_keys
}

