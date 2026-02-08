package br.edu.ifg.model;

public class File extends Element{
    //conteúdo do arquivo (o texto que está escrito nele)
    private String content;

    public File(String name, Directory parent) {
        super(name, parent);
        this.content = ""; //comeca vazio
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //para adicionar texto ao arquivo que já contem
    public void appendContent(String newContent) {
        if (this.content.isEmpty()) {
            this.content = newContent;
        } else {
            this.content += "\n" + newContent;
        }
    }
}
